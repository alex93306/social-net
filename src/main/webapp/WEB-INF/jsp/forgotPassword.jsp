<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <%--todo: investigate other required stuff--%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <%--todo: add local bootstrap--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <%--todo: move to *.css--%>
    <style>
        .resetPasswordForm {
            width: 500px;
            margin: 150px auto;
        }
    </style>

    <%--todo: improve name--%>
    <title>Forgot password</title>
</head>
<body>
<div class="resetPasswordForm">
    <h3 class="mb-3 text-center">Reset password</h3>
    <div class="card">
        <div class="card-body">
            <form action="<s:url value="/forgotPassword"/>" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control" type="text" id="email" placeholder="Enter your email"/>
                </div>
                <div class="text-center">
                    <button class="btn btn-primary"><s:message code="resetPassword.button"/></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>