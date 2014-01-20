<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TodoList</title>
</head>
<body>

<strong> 用户名: </strong> ${user.userName}
<hr/>

<form action="/content/add" method="post">
    <input name="context" type="text" placeholder="write new context here" />
    <input type="submit" value="submit" />
</form>

<c:forEach var="content" items="${contents}">
    <form action="/content/remove" method="post">
        ${content.context} : ${content.updateTime}
        <input name="contentId" type="hidden" value=${content.contentId} />
        <input type="submit" value="remove" />
        <br />
    </form>
</c:forEach>


</body>
</html>