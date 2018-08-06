<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jnc985
  Date: 06-Aug-18
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST USERS</title>
</head>
<body>
    <s:iterator value="model" var="user">
        <p>
            <s:property value="name" />
        </p>
        <br>
    </s:iterator>
</body>
</html>
