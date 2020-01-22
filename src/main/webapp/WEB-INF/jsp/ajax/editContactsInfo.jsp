<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="tab-pane fade show active" id="list-general-item">
    <div class="card-header">
        Контакты
    </div>
    <div class="card-body">
        <form:form action="/saveGeneralInfo" method="post">
            <div class="row form-group">
                <label for="country" class="col-4 col-form-label text-right">Страна:</label>
                <div class="col">
                    <input class="form-control" type="text" id="country" value="Беларусь">
                </div>
            </div>
            <div class="row form-group">
                <label for="country" class="col-4 col-form-label text-right">Город:</label>
                <div class="col">
                    <input class="form-control" type="text" id="city" value="Минск">
                </div>
            </div>
        </form:form>
    </div>
</div>
</div>