<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="tab-pane fade show active" id="list-general-item">
    <div class="card-header">
        Контакты
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
        <form:form id="contactsInfoForm" action="/ajaxSaveContactsInfo" method="post" modelAttribute="appUser">
            <div class="row form-group">
                <label for="country" class="col-4 col-form-label text-right">Страна:</label>
                <div class="col">
                    <form:input path="country" cssClass="form-control" id="country"/>
                </div>
            </div>
            <div class="row form-group">
                <label for="country" class="col-4 col-form-label text-right">Город:</label>
                <div class="col">
                    <form:input path="city" cssClass="form-control" id="city"/>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </form:form>
    </div>
</div>
</div>
<script>
    $(function () {
        var $form = $('#contactsInfoForm');
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