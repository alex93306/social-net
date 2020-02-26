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
        <div class="col-3">
            <div class="card">
                <div class="card-body">
                    <img class="mb-2" src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg"
                         width="150" height="150">
                    <div class="col text-center">
                        <%--todo--%>
                        <a class="btn btn-primary" href="/editProfile">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-7">
            <div class="card">
                <div class="card-body">
                    <div class="h5">Александр Романович</div>
                    <hr/>
                    <div class="row mb-2">
                        <div class="col-4">День рождения:</div>
                        <div class="col">5 марта 1992 г.</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">Город:</div>
                        <div class="col">Минск</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">Семейное положение:</div>
                        <div class="col">не женат</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">Образование:</div>
                        <div class="col">БГУИР (бывш. МРТИ) '14</div>
                    </div>
                    <div class="row mb-2">
                        <button class="btn btn-block btn-summary" type="button" data-toggle="collapse" data-target="#collapseContent">
                            Показать подрубную информацию информацию
                        </button>
                    </div>
                    <div class="collapse" id="collapseContent">
                        <div class="row mb-2">
                            <div class="col-4">Родной город:</div>
                            <div class="col">Берёза</div>
                        </div>
                        <div class="row mb-2">
                            <div class="col-4">Языки:</div>
                            <div class="col">Беларуская, Русский, English</div>
                        </div>
                        <div class="row mb-2">
                            <div class="col-4">Skype:</div>
                            <div class="col">alex93306</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <!--todo:-->
    <!--<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</div>
</body>
</html>