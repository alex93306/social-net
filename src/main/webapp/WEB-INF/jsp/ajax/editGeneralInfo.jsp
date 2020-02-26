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

        <%--todo: model attribute--%>
        <form:form action="/ajaxSaveGeneralInfo" method="post" modelAttribute="generalInfoForm">
            <div class="row form-group">
                <label for="firstName" class="col-4 col-form-label text-right">Имя:</label>
                <div class="col">
                    <form:input path="firstName" cssClass="form-control"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="lastName" class="col-4 col-form-label text-right">Фамилия:</label>
                <div class="col">
                    <form:input path="lastName" cssClass="form-control"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="maidenName" class="col-4 col-form-label text-right">Девичья фамилия:</label>
                <div class="col">
                    <form:input path="maidenName" cssClass="form-control"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="gender" class="col-4 col-form-label text-right">Пол:</label>
                <div class="col">
                    <form:select path="gender" cssClass="form-control">
                        <%--todo список --%>
                        <form:option value="FEMALE" label="женский"/>
                        <form:option value="MALE" label="мужской"/>
                    </form:select>
                </div>
            </div>
            <div class="row form-group">
                <label for="maritalStatus" class="col-4 col-form-label text-right">Семейное положение:</label>
                <div class="col">
                    <form:select path="maritalStatus" cssClass="form-control">
                        <%--todo зависимые от пола--%>
                        <%--todo список получение --%>
                        <form:option value="SINGLE" label="неженат"/>
                        <form:option value="MARRIED" label="женат"/>
                    </form:select>
                </div>
            </div>
            <div class="row form-group">
                <label for="birthday" class="col-4 col-form-label text-right">День рождения:</label>
                <div class="col">
                    <%--todo: rename id and path--%>
                    <form:input cssClass="form-control" path="birthday" type="date"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="homeCity" class="col-4 col-form-label text-right">Родной город:</label>
                <div class="col">
                    <form:input cssClass="form-control" path="homeCity"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="language" class="col-4 col-form-label text-right">Языки:</label>
                <div class="col">
                    <form:select path="language" cssClass="form-control" items="${languageOptions}" itemLabel="name" itemValue="id"/>
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