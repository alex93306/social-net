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

    <style>
        .signInForm {
            width: 500px;
            margin: 150px auto;
        }
    </style>
</head>
<body>
<div class="signInForm">
    <h3 class="mb-3 text-center">Sign in</h3>
    <div class="card">
        <div class="card-body">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control" type="text" id="email" placeholder="Enter your email"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" id="password" placeholder="Enter your password"/>
                    <small class="form-text text-muted">
                        <a class="text-primary" href="#">Forgot password</a>
                    </small>
                </div>
                <%--todo:--%>
                <%--<div class="custom-control custom-checkbox pb-3">--%>
                    <%--<input type="checkbox" class="custom-control-input" id="remember-me">--%>
                    <%--<label for="remember-me" class="custom-control-label">Remember me</label>--%>
                <%--</div>--%>
                <div class="text-center">
                    <button class="btn btn-primary">Sign in</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>