<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%--todo:--%>
    <title>Title</title>
    <jsp:include page="includes/bootstrap.jsp"/>
</head>
<body>
<div class="card">
    <div class="card-body">
        <form:form action="/createChat"  method="post" modelAttribute="createChatForm">
            <div class="form-group">
                <label for="">Название чата</label>
                <form:input path="name" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="">Укажите id собеседника</label>
                <form:input path="memberAppUserID" cssClass="form-control"/>
            </div>
            <button type="submit">Создать чат</button>
        </form:form>
    </div>
</div>
</body>
</html>
