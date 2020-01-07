<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/createChat"  method="post" modelAttribute="createChatForm">
        <form:input path="name"/>
        <form:input path="memberAppUserID"/>
        <button type="submit">Create chat</button>
    </form:form>
</body>
</html>
