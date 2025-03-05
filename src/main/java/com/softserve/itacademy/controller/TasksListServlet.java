package com.softserve.itacademy.controller;

import com.softserve.itacademy.repository.TaskRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.softserve.itacademy.model.Task;
import java.util.List;


@WebServlet("/tasks-list")
public class TasksListServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch "sort" query parameter from the request
        String sort = request.getParameter("sort");
        // Retrieve the list of tasks from the repository
        List<Task> tasks = taskRepository.all();

        // Sort the tasks by priority if "sort=priority" is specified in the query
        if ("priority".equalsIgnoreCase(sort)) {
            tasks.sort((task1, task2) -> task1.getPriority().compareTo(task2.getPriority()));
        }

        // Set the sorted/unsorted task list as a request attribute
        request.setAttribute("tasks", tasks);
        // Forward to the JSP page
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/tasks-list.jsp");
        requestDispatcher.forward(request, response);
    }

}
