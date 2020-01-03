<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="includes/bootstrap.jsp"/>

    <%--todo: move to file--%>
    <style>
        .sign-form {
            width: 500px;
            margin: 150px auto;
        }
    </style>
</head>
<body>
<div class="sign-form">
    <h3 class="mb-3 h3 text-center"><s:message code="loginForm.caption"/></h3>
    <div class="card shadow">
        <div class="card-body">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                        <%--todo I'm not sure--%>
                    <c:choose>
                        <c:when test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                        </c:when>
                        <c:otherwise>
                            Login failed.
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>
            <form action="<s:url value="/login"/>" method="post">
                <div class="form-group">
                    <label for="email"><s:message code="loginForm.label.email"/></label>
                    <s:message code="loginForm.placeholder.email" var="emailPlaceholder"/>
                    <input class="form-control" type="text" id="email" name="username" placeholder="${emailPlaceholder}" value="test@test.com"/>
                </div>
                <div class="form-group">
                    <label for="password"><s:message code="loginForm.label.password"/></label>
                    <s:message code="loginForm.placeholder.password" var="passwordPlaceholder"/>
                    <input class="form-control" type="password" id="password" name="password" placeholder="${passwordPlaceholder}" value="password"/>
                    <small class="form-text text-muted">
                        <s:url value="/forgotPassword" var="forgotPasswordUrl"/>
                        <a class="text-primary" href="${forgotPasswordUrl}"><s:message code="loginForm.link.forgotPassword"/></a>
                    </small>
                </div>
                <div class="text-center">
                    <button class="btn btn-block btn-primary"><s:message code="loginForm.button.login"/></button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <a class="btn btn-block mt-3 border border-primary" href="<s:url value="/register"/>">
                <s:message code="loginForm.button.signUp"/>
            </a>
        </div>
    </div>
</div>
</body>
</html>