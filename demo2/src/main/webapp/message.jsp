<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 19/03/2021
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Mon message</title>
</head>
<body>
    <c:out value="${msg.msg}"/>
    <c:if test="${msg.repeat == 1}">
        <p>${msg.msg}</p>
    </c:if>
    <c:if test="${msg.repeat > 1}">
        <p>${msg.msg}</p>
        <p>${msg.msg}</p>
    </c:if>


</body>
</html>
