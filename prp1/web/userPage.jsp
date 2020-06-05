<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 26.05.2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current user</title>
</head>
<body>
<div align="center">
    <h2>Users Management - Current user</h2>
</div>
<%  String name = "";
    int age = 0;
    long id = 0;
    if (request.getAttribute("userForEdit") != null) {
        User user = (User) request.getAttribute("userForEdit");
        name = user.getName();
        age = user.getAge();
        id = user.getId();
    }

%>
<form action="/user" method="post">
    <label>Name:
        <input type="text" name="name" value="<%=name%>"><br/>
    </label>

    <label>Age:
        <input type="text" name="age" value="<%=age%>"><br/>
    </label>
    <input type="text" name="id" value="<%=id%>" hidden="true">
</form>
<br>
<br>
</body>
</html>
</body>
</html>