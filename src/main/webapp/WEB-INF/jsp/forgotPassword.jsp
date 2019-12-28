<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="includes/bootstrap.jsp"/>

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