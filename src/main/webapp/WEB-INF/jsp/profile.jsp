<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%--todo: there's additional requirst to /{favicon} if doens't present--%>
    <%--<link rel="shortcut icon" href="https://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico?v=4f32ecc8f43d">--%>
    <title>Title</title>

    <jsp:include page="includes/bootstrap.jsp"/>

</head>
<body>
<spring:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Logout</button>
</form>
<a href="${logoutUrl}">Logout</a>
<div class="avatar">
    <div><img src="https://www.drupal.org/files/issues/default-avatar.png"/></div>
    <div>
        <spring:url var="editProfileUrl" value="/editProfile"/>
        <a href="${editProfileUrl}">Edit Profile</a>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-2">
        </div>
        <div class="col-8">
            <div class="row mt-5 mb-3">
                <div class="col text-center">
                    <img class="mb-2" src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg"
                         width="150" height="150">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col text-center">
                    <button class="btn btn-primary">Add to Friends</button>
                    <button class="btn btn-primary">Send message</button>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Name</div>
                <div class="col">Alex Romanovich</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Birthday</div>
                <div class="col">05.03.1992</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Education</div>
                <div class="col">BSUIR</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Marital Status</div>
                <div class="col">Single</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Gender</div>
                <div class="col">Male</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Work</div>
                <div class="col">Epam</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Education</div>
                <div class="col">BSUIR</div>
            </div>
            <div class="row mb-2">
                <div class="col text-right">Marital Status</div>
                <div class="col">Single</div>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>
</html>
