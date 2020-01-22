<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <jsp:include page="includes/bootstrap.jsp"/>

    <style>
        .btn-summary:hover {
            background-color: #f8f9fa !important;
        }
    </style>

</head>
<body class="bg-light">
<nav class="navbar bg-primary">
    <div class="container">
        <a class="navbar-brand text-white" href="#">VK</a>
    </div>
</nav>
<div class="container">
    <div class="row mt-3">
        <div class="col-2">
            <ul class="list-unstyled">
                <li><a href="#">Моя страница</a></li>
                <li><a href="#">Новости</a></li>
                <li><a href="#">Сообщения</a></li>
            </ul>

        </div>
        <div class="col-7">
            <div class="card">
                <div class="tab-content" id="nav-tabContent">
                    <%-- Here will be tabs content--%>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="card">
                <div class="card-body">
                    <div class="list-group" id="list-tab" role="tablist">
                        <%--tdo--%>
                        <%--//todo: url context--%>
                        <a class="list-group-item list-group-item-action active" href="/ajaxEditGeneralInfo" data-toggle="list">
                            Основное
                        </a>
                        <%--//todo: url context--%>
                        <a class="list-group-item list-group-item-action" href="/ajaxEditContactsInfo" data-toggle="list">
                            Контакты
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <!--todo:-->
    <!--<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script>
        $(function () {
            $("a").on("click", function () {
                var url = $(this).attr("href");
                $.ajax(url).done(function (data) {
                    $('#nav-tabContent').html(data);
                })
            });
        });
    </script>

</div>
</body>
</html>