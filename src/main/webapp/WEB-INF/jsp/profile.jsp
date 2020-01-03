<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<spring:url var="logoutUrl" value="/logout"/>
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
