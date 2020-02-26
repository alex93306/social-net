<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

<jsp:include page="includes/navbar.jsp"/>

<div class="container">
    <div class="row mt-3">
        <div class="col-2">
            <jsp:include page="includes/navigation.jsp"/>
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
                        <%--//todo: url context--%>
                        <a class="list-group-item list-group-item-action" href="/ajaxEditContactsInfo" data-toggle="list">
                            Интересы
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
            $("#list-tab a").on("click", function () {
                var url = $(this).attr("href");
                // $.ajax(url).done(function (data) {
                //     $('#nav-tabContent').html(data);
                // }).fail(function (event, jqXhr) {
                //     //todo:
                //     if (jqXhr.status === 401) {
                //         window.location.href = '/login';
                //     }
                // });
                $.ajax({
                    url: url,
                    success: function (data, status, jqXhr) {
                        $('#nav-tabContent').html(data);
                    },
                    error: function (jqXhr) {
                        //todo:
                        if (jqXhr.status === 403) {
                            window.location.href = '/login';
                        }
                    }
                });
            });

            // todo
            $('#list-tab a:first-child').click();
        });
    </script>

</div>
</body>
</html>