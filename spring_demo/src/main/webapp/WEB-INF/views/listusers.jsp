<%--
  Created by IntelliJ IDEA.
  User: jnc985
  Date: 06-Aug-18
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users</h1>

<c:forEach items="${userlist}" var = "user">
    Name <c:out value = "${user.name}" /><br>
</c:forEach>
</body>
</html>
