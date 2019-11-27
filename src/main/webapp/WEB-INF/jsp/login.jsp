<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <%-- todo: implement--%>
        <form action="/login" method="post">
            <input type="text" name="email" placeholder="Email"/>
            <input type="password" name="password" placeholder="Password"/>
            <input type="submit" value="Login"/>
        </form>
        <a href="<s:url value="/register"/>">Create New Account</a>
        <a href="<s:url value="/forgotPassword"/>">Forgot Password</a>
    </div>
</body>
</html>
