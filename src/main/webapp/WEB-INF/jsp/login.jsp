<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <%--todo: investigate other required stuff--%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <%--todo: add local bootstrap--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"/>">--%>

    <style>
        .signInForm {
            width: 500px;
            margin: 150px auto;
        }
    </style>
</head>
<body>
<div class="signInForm">
    <h3 class="mb-3 h3 text-center">Sign in</h3>
    <div class="card">
        <div class="card-body">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <c:choose>
                        <c:when test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                        </c:when>
                        <c:otherwise>
                            Login failed.
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been signed out.
                </div>
            </c:if>
            <form action="<s:url value="/login"/>" method="post">
                <div class="form-group">
                    <label for="email"><s:message code="loginForm.email.label"/></label>
                    <input class="form-control" type="text" id="email" name="username" placeholder="Enter your email"/>
                </div>
                <div class="form-group">
                    <label for="password"><s:message code="loginForm.password.label"/></label>
                    <input class="form-control" type="password" id="password" name="password"
                           placeholder="Enter your password"/>
                    <small class="form-text text-muted">
                        <a class="text-primary" href="#">Forgot password?</a>
                    </small>
                </div>
                <div class="text-center">
                    <button class="btn btn-block btn-primary">Log in</button>
                </div>
            </form>
            <a class="btn btn-block mt-3 border border-primary" href="<s:url value="/register"/>">Sign up</a>
        </div>
    </div>
</div>
</body>
</html>