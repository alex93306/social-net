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
                <label for="chatName">Название чата</label>
                <form:input path="name" cssClass="form-control" id="chatName"/>
            </div>
            <div class="form-group">
                <label for="chatMemberID">Укажите собеседника</label>
                <form:select path="memberAppUserID" id="chatMemberID">
                    <form:option label="----- Select -----" value="${null}"/>
                    <form:options items="${userList}"  itemLabel="fullName" itemValue="id"/>
                </form:select>
            </div>
            <button type="submit">Создать чат</button>
        </form:form>
    </div>
</div>
</body>
</html>
