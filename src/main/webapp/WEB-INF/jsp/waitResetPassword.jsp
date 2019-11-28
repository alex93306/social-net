<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 24.11.2019
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--todo: implements--%>
<h1>Please check your email, we've sent instructions to reset newPassword.</h1>
<a href="<s:url value="/forgotPassword"/>">Use another email to recover newPassword</a>
</body>
</html>

