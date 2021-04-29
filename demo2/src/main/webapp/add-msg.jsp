<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 19/03/2021
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un message</title>
</head>
<body>
<form method="POST" action="save-msg">
    <input type="text" name="msg"/>
    <input type="number" name="repeat"/>
    <input type="submit">
</form>

</body>
</html>
