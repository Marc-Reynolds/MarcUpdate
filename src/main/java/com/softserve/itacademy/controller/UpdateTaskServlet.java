package com.softserve.itacademy.controller;

import com.softserve.itacademy.exception.TaskNotFoundException;
import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class UpdateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        Task task = taskRepository.read(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID '" + taskId + "' not found in To-Do List!");
        } else {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task(
                request.getParameter("title"),
                Priority.valueOf(request.getParameter("priority"))
        );
        task.setId(Integer.parseInt(request.getParameter("id")));
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
