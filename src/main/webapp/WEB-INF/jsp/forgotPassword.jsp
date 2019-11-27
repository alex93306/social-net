<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 23.09.2019
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<s:url value="/forgotPassword"/>" method="POST" >
        <input type="email" name="email" placeholder="Email"/>
        <input type="submit" value="Reset password"/>
    </form>
</body>
</html>
