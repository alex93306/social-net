<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--todo: investigate why?--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="tab-pane fade show active" id="list-general-item">
    <div class="card-header">
        Основное
    </div>
    <div class="card-body">
        <div>
            <c:if test="${isSaved}">
                <div class="alert alert-success">
                    Saved
                </div>
            </c:if>
        </div>
        <form:form action="/ajaxSaveGeneralInfo" method="post" modelAttribute="appUser" id="generalInfoForm">
            <div class="row form-group">
                <label for="firstName" class="col-4 col-form-label text-right">Имя:</label>
                <div class="col">
                    <form:input path="firstName" cssClass="form-control" id="firstName"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="lastName" class="col-4 col-form-label text-right">Фамилия:</label>
                <div class="col">
                    <form:input path="lastName" cssClass="form-control" id="lastName"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="gender" class="col-4 col-form-label text-right">Пол:</label>
                <div class="col">
                    <%--<select id="gender" name="gender" class="form-control">--%>
                        <%--<option value="FEMALE">женский</option>--%>
                        <%--<option value="MALE" selected>мужской</option>--%>
                    <%--</select>--%>
                </div>
            </div>
            <div class="row form-group">
                <label for="maritalStatus" class="col-4 col-form-label text-right">Семейное положение:</label>
                <div class="col">
                    <%--<select id="maritalStatus" name="maritalStatus" class="form-control">--%>
                        <%--<option>Не выбрано</option>--%>
                        <%--<!--todo зависимые поля-->--%>
                        <%--<option value="MARRIED">Женат</option>--%>
                        <%--<option value="SINGLE" selected>Не женат</option>--%>
                    <%--</select>--%>
                </div>
            </div>
            <div class="row form-group">
                <label for="birthday" class="col-4 col-form-label text-right">День рождения::</label>
                <div class="col">
                    <%--<select id="day" name="day" class="form-control">--%>
                        <%--<option>Не выбрано</option>--%>
                        <%--<!--todo зависимые поля-->--%>
                        <%--<option value="MARRIED">Женат</option>--%>
                        <%--<option value="SINGLE" selected>Не женат</option>--%>
                    <%--</select>--%>
                </div>
            </div>
            <hr/>
            <div class="text-center">
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </form:form>
    </div>
</div>
</div>
<script>
    $(function () {
        $("a").on("click", function () {
            var url = $(this).attr("href");
            $.ajax(url).done(function (data) {
                $('#nav-tabContent').html(data);
            })
        });

        var $form = $('#generalInfoForm');
        $form.submit(function (e) {
            e.preventDefault();

            $.ajax({
                type: $form.attr('method'),
                url: $form.attr('action'),
                data: $form.serialize(),
                success: function (data) {
                    $('#nav-tabContent').html(data);
                }
            })

        })
    });
</script>