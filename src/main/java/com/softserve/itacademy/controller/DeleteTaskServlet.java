package com.softserve.itacademy.controller;

import com.softserve.itacademy.exception.TaskNotFoundException;
import com.softserve.itacademy.repository.TaskRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        boolean status = taskRepository.delete(taskId);
        if (status) {
            response.sendRedirect("/tasks-list");
        } else {
            throw new TaskNotFoundException("Task with ID '" + taskId + "' not found in To-Do List!");
        }
    }
}
