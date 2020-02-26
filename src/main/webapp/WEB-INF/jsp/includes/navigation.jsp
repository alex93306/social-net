<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<ul class="list-unstyled">
    <s:url value="/" var="homeUrl"/>
    <li><a href="${homeUrl}">Моя страница</a></li>
    <li><a href="#">Сообщения</a></li>
    <li><a href="#">Друзья</a></li>
</ul>
