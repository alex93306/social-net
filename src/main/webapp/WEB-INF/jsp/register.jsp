<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--todo: implement--%>

<div>
    <form action="<s:url value="/register" />" method="post">
        <input type="text" name="firstName" placeholder="First Name"/>
        <input type="text" name="lastName" placeholder="Last Name"/>
        <input type="email" name="email" placeholder="Email"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="password" name="repeatPassword" placeholder="Repeat password"/>
        <input type="date" name="birthday" placeholder="Birthday"/>
        <select name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>
        <input type="submit" value="Create Account"/>
    </form>
</div>
</body>
</html>
