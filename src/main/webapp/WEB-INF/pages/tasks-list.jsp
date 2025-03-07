<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Tasks</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
    <%@include file="header.html"%>

    <div class="container">

    <h2>List of Tasks</h2>

    <%
        List<Task> todo = (List<Task>)request.getAttribute("tasks");
        if (!todo.isEmpty()) {
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>
                <a href="/tasks-list?sort=priority">Priority</a>
            </th>
            <th>Status</th>
            <th colspan="3">Operation</th>
        </tr>
        <%
            for (int i=0; i<todo.size(); i++) {
        %>
        <tr>
            <td><%= i + 1%></td>
            <td style="<%= todo.get(i).isDone() ? "text-decoration: line-through;" : "" %>">
                <%= todo.get(i).getTitle()%>
            </td>
            <td><%= todo.get(i).getPriority()%></td>
            <td><%= todo.get(i).isDone() ? "Done" : "Pending" %></td>
            <td>
                <a href="/read-task?id=<%= todo.get(i).getId()%>">Read</a>
            </td>
            <td>
                <a href="/edit-task?id=<%= todo.get(i).getId()%>">Edit</a>
            </td>
            <td>
                <a href="/delete-task?id=<%= todo.get(i).getId()%>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>    <%
        } else {
    %>
    <p>You don't have any task!</p>
    <p>First <a href="/create-task">Add new Task</a> !</p>
    <%
        }
    %>

    </div>
    <footer>
        &copy; <%= java.time.Year.now().getValue() %> Awesome To-Do List. All rights reserved.
    </footer>
</body>
</html>
