<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 26.05.2020
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Здравствуйте!</title>
</head>
<body>
<form method="post">
    <h1>Login</h1>
    <label>Login</label>
    <input type="text" name="email">
    <br>
    <label>Password</label>
    <input type="text" name="password">
    <br>
    <button type="submit" value="Login"></button>
</form>
<form action = "users" method="get">
    <input type="submit" value="Login">
</form>
</body>
</html>