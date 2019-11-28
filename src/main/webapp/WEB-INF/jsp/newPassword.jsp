<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 24.11.2019
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--todo: implement--%>
<sf:form action="/resetPassword" method="POST" modelAttribute="newPasswordForm">
    <sf:hidden path="email"/>
    <sf:password path="newPassword" placeholder="New Password"/>
    <sf:password path="repeatPassword" placeholder="Repeat Password"/>
    <input type="submit" value="Submit"/>
</sf:form>
</body>
</html>
