<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 14.09.2019
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--todo: implement--%>

<div>
    <form action="/register" method="post">
        <input type="text" name="firstName" placeholder="First Name"/>
        <input type="text" name="lastName" placeholder="Last Name"/>
        <input type="email" name="email" placeholder="Email"/>
        <input type="password" name="password" placeholder="Password"/>
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
