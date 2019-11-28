<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 22.09.2019
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .avatar {
            background-color: aliceblue;
            width: 250px;
            float: left;
        }
        .userInfo {
            background-color: antiquewhite;
            width: auto;
            margin-left: 250px;
        }
    </style>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="avatar">
           <div><img src="https://www.drupal.org/files/issues/default-avatar.png"/></div>
        <div>
            <a href="/editprofile">Edit Profile</a>
        </div>
    </div>
    <div class="userInfo">
        <div class="conta">
            <span>Name: </span>
            <span>${appUser.fullName}</span>
        </div>
        <div>
            <span>Birthday: </span>
            <span>${appUser.birthDate}</span>
        </div>
        <div>
            <span>City: </span>
            <span>${appUser.city}</span>
        </div>
        <div>
            <span>Education: </span>
            <span>${appUser.education}</span>
        </div>
        <div>
            <span>About: </span>
            <span>${appUser.about}</span>
        </div>
    </div>
</body>
</html>
