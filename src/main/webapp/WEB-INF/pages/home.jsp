<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../styles/main.css">
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html"%>

<div class="container">
    <h2>Welcome to Awesome To-Do List!</h2>
    <p>Stay organized and boost your productivity with our app.</p>

    <div class="cta-buttons">
        <a href="/tasks-list">View Tasks</a>
        <a href="/create-task">Create Task</a>
    </div>
</div>

<footer>
    &copy; <%= java.time.Year.now().getValue() %> Awesome To-Do List. All rights reserved.
</footer>
</body>
</html>