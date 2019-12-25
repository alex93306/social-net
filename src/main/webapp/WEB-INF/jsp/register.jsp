<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%--todo: investigate why?--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--todo: title, metas and other according to boostrap-->
    <!--todo: import if unreacale cdn-->
    <%--todo: create jsp and import a such stuff--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--todo: move to separate--%>
    <style>
        .signUpForm {
            width: 500px;
            margin: 150px auto;
        }
    </style>
</head>
<body>
<div class="signUpForm">
    <h3 class="mb-3 text-center">Sign up</h3>
    <div class="card shadow-sm">
        <div class="card-body">
            <form:form action="/register" method="post" modelAttribute="registerForm">
                <s:hasBindErrors name="registerForm">
                    <div class="alert alert-danger">
                        <form:errors path="*"/>
                    </div>
                </s:hasBindErrors>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <form:label path="firstName" cssErrorClass="error"><s:message
                                    code="registerForm.label.firstName"/></form:label>
                            <s:message code="registerForm.placeholder.firstName" var="firstNamePlaceholder"/>
                            <form:input path="firstName" cssClass="form-control" cssErrorClass="form-control"
                                        placeholder="${firstNamePlaceholder}"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <form:label path="lastName" cssErrorClass="error">Last Name</form:label>
                            <form:input path="lastName" cssClass="form-control" placeholder="Last name"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="email" cssErrorClass="error">Email</form:label>
                    <form:input path="email" cssClass="form-control" placeholder="Email"/>
                </div>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <form:label path="password" cssErrorClass="error">Password</form:label>
                            <form:password path="password" cssClass="form-control" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <form:label path="repeatPassword" cssErrorClass="error">Repeat Password</form:label>
                            <form:password path="repeatPassword" cssClass="form-control"
                                           placeholder="Confirm password"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="birthDate" cssErrorClass="error">Birthday</form:label>
                    <form:input path="birthDate" type="date" cssClass="form-control"/>
                </div>
                <div>
                    Gender
                </div>
                <div class="form-group">
                    <div class="custom-control custom-radio custom-control-inline">
                        <form:radiobutton path="gender" value="Female" cssClass="custom-control-input"/>
                        <form:label path="gender" cssClass="custom-control-label"
                                    cssErrorClass="error">Female</form:label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <form:radiobutton path="gender" value="Male" cssClass="custom-control-input"/>
                        <form:label path="gender" cssClass="custom-control-label"
                                    cssErrorClass="error">Male</form:label>
                    </div>
                </div>

                <div class="mt-3 text-center">
                    <button class="btn btn-block btn-primary">Sign up</button>
                </div>

                <div class="mt-3 text-center">
                    <a class="btn btn-block border border-primary" href="<s:url value="/login"/>">Log in instead</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>