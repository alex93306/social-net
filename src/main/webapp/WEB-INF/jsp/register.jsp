<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .loginForm {
            width: 750px;
            margin: auto;
            margin-top: 250px;
        }

        label.error, span.error {
            color: red;
        }
        input.error {
            background-color: #ffcccc;;
        }
    </style>
</head>
<body>

<%--todo: implement--%>

<div class="loginForm">
    <form:form action="/register" method="POST" modelAttribute="newUserForm">
        <form:label path="firstName" cssErrorClass="error">First Name</form:label>
        <form:input path="firstName" cssErrorClass="error"/>
        <form:errors path="firstName" cssClass="error"/><br/>

        <form:label path="lastName" cssErrorClass="error">Last Name</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/><br/>

        <form:label path="email" cssErrorClass="error">Email</form:label>
        <form:input path="email" type="email"/>
        <form:errors path="email" cssClass="error"/><br/>

        <form:label path="password" cssErrorClass="error">Password</form:label>
        <form:password path="password" />
        <form:errors path="password" cssClass="error"/><br/>

        <form:label path="repeatPassword" cssErrorClass="error">Repeat Password</form:label>
        <form:password path="repeatPassword" />
        <form:errors path="repeatPassword" cssClass="error"/><br/>

        <form:label path="birthDate" cssErrorClass="error">Birthday</form:label>
        <form:input path="birthDate" type="date"/>
        <form:errors path="birthDate" cssClass="error"/><br/>

        <form:label path="gender" cssClass="error">Gender</form:label>
        <form:select path="gender"/>
        <form:errors path="gender" cssClass="error"/><br/>

        <input type="submit" value="Create Account"/>
    </form:form>
</div>
</body>
</html>
