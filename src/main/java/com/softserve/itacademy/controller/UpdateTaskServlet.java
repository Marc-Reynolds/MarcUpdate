package com.softserve.itacademy.controller;

import com.softserve.itacademy.exception.TaskNotFoundException;
import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class UpdateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;
    private Task task;

    @Override
    public void init() throws ServletException {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        task = taskRepository.read(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID '" + taskId + "' not found in To-Do List!");
        } else {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        task.setTitle(request.getParameter("title"));
        task.setPriority(Priority.valueOf(request.getParameter("priority")));
        boolean status = taskRepository.update(task);
        if (status) {
            response.sendRedirect("/tasks-list");
        } else {
            request.setAttribute("error", "Task with a given name already exists!");
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request, response);
        }
    }
}
