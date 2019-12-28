<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%--todo: investigate why?--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="includes/bootstrap.jsp"/>

    <%--todo: move to separate--%>
    <style>
        .signUpForm {
            width: 500px;
            margin: 150px auto;
        }
        .error-msg {
            color: red;
        }
    </style>
</head>
<body>
<div class="signUpForm">
    <h3 class="mb-3 text-center">Sign up</h3>
    <div class="card shadow-sm">
        <div class="card-body">
            <form:form action="/register" method="post" modelAttribute="registerForm">
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <form:label path="firstName"><s:message code="registerForm.label.firstName"/></form:label>
                            <s:message code="registerForm.placeholder.firstName" var="firstNamePlaceholder"/>
                            <form:input path="firstName" cssClass="form-control" placeholder="${firstNamePlaceholder}"/>
                            <form:errors path="firstName" cssClass="error-msg"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <form:label path="lastName" >Last Name</form:label>
                            <form:input path="lastName" cssClass="form-control" placeholder="Last name"/>
                            <form:errors path="lastName" cssClass="error-msg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="email" >Email</form:label>
                    <form:input path="email" cssClass="form-control" placeholder="Email"/>
                    <form:errors path="email" cssClass="error-msg"/>
                </div>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <form:label path="password" >Password</form:label>
                            <form:password path="password" cssClass="form-control" placeholder="Password"/>
                            <form:errors path="password" cssClass="error-msg"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <form:label path="repeatPassword" >Repeat Password</form:label>
                            <form:password path="repeatPassword" cssClass="form-control"
                                           placeholder="Confirm password"/>
                            <form:errors path="repeatPassword" cssClass="error-msg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="birthDate" >Birthday</form:label>
                    <form:input path="birthDate" type="date" cssClass="form-control"/>
                    <form:errors path="birthDate" cssClass="error-msg"/>
                </div>
                <div>
                    Gender
                </div>
                <div class="form-group">
                    <div class="custom-control custom-radio custom-control-inline">
                        <form:radiobutton path="gender" id="genderFemale" value="FEMALE"
                                          cssClass="custom-control-input"/>
                        <form:label path="gender" for="genderFemale" cssClass="custom-control-label">Female</form:label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <form:radiobutton path="gender" value="MALE" id="genderMale" cssClass="custom-control-input"/>
                        <form:label path="gender" for="genderMale" cssClass="custom-control-label">Male</form:label>
                    </div>
                    <form:errors path="gender" element="div" cssClass="error-msg"/>
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