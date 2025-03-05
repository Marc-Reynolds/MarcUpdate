<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html" %>
<div class="container">

<table>

    <h2>Read existing Task</h2>

    <% Task task = (Task) request.getAttribute("task"); %>

    <tr>
        <td>Id:</td>
        <td>
            <strong><%= task.getId()%>
            </strong>
        </td>
    </tr>
    <tr>
        <td>Description:</td> <!-- Add a label for Description -->
        <td>
            <strong><%= task.getDescription() %>
            </strong> <!-- Display the description -->
        </td>
    </tr>
    <tr>
        <td>Title:</td>
        <td>
            <strong><%= task.getTitle()%>
            </strong>
        </td>
    </tr>
    <tr>
        <td>Priority:</td>
        <td>
            <strong><%= task.getPriority()%>
            </strong>
        </td>
    </tr>
</table>
</div>
<footer>
    &copy; <%= java.time.Year.now().getValue() %> Awesome To-Do List. All rights reserved.
</footer>
</body>
</html>
