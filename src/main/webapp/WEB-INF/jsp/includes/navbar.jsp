<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar bg-primary">
    <div class="container">
        <a class="navbar-brand text-white" href="#">VK</a>
        <%--todo--%>
        <div class="dropdown">
            <button class="btn text-white font-weight-bolder dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                ${appUser.firstName}
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <%--todo--%>
                <a class="dropdown-item" href="/">Моя страница</a>
                <hr/>
                <%--todo: custom tag addd--%>
                <form:url value="/editProfile" var="editProfileUrl"/>
                <a class="dropdown-item" href="${editProfileUrl}">Редактировать</a>
                <a class="dropdown-item" href="#">Another action</a>
                <hr/>
                <spring:url var="logoutUrl" value="/logout"/>
                <form action="${logoutUrl}" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="dropdown-item" type="submit">Выйти</button>
                </form>
            </div>
        </div>
    </div>
</nav>