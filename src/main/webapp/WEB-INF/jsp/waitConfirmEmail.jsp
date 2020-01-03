<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="includes/bootstrap.jsp"/>
    <title>Подтвердите ваш e-mail</title>
</head>
<body>
<div class="card shadow mt-5" style="width: 500px">
    <div class="card-body">
        <h2>Подтвердите ваш e-mail</h2>
        <div>
            Мы отправили письмо для активации профиля на ${appUser.email}. Пожалуйста, перейдите по ссылке из письма, чтобы активировать профиль.
        </div>
    </div>
</div>
</body>
</html>
