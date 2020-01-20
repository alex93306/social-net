<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="card-header">
    Основное
</div>
<div class="card-body">
    <form:form action="/saveGeneralInfo" method="post">
        <div class="row form-group">
            <label for="firstName" class="col-4 col-form-label text-right">Имя:</label>
            <div class="col">
                <input class="form-control" type="text" id="firstName" value="Александр">
            </div>
        </div>
        <div class="row form-group">
            <label for="lastName" class="col-4 col-form-label text-right">Фамилия:</label>
            <div class="col">
                <input class="form-control" type="text" id="lastName" value="Романович">
            </div>
        </div>
        <div class="row form-group">
            <label for="gender" class="col-4 col-form-label text-right">Пол:</label>
            <div class="col">
                <select id="gender" name="gender" class="form-control">
                    <option value="FEMALE">женский</option>
                    <option value="MALE" selected>мужской</option>
                </select>
            </div>
        </div>
        <div class="row form-group">
            <label for="maritalStatus" class="col-4 col-form-label text-right">Семейное положение::</label>
            <div class="col">
                <select id="maritalStatus" name="maritalStatus" class="form-control">
                    <option>Не выбрано</option>
                    <!--todo зависимые поля-->
                    <option value="MARRIED">Женат</option>
                    <option value="SINGLE" selected>Не женат</option>
                </select>
            </div>
        </div>
        <div class="row form-group">
            <label for="birthday" class="col-4 col-form-label text-right">День рождения::</label>
            <div class="col">
                <select id="day" name="day" class="form-control">
                    <option>Не выбрано</option>
                    <!--todo зависимые поля-->
                    <option value="MARRIED">Женат</option>
                    <option value="SINGLE" selected>Не женат</option>
                </select>
            </div>
        </div>
        <hr/>
        <div class="text-center">
            <button class="btn btn-primary" type="button">Сохранить</button>
        </div>
    </form:form>
</div>
</div>