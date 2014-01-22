<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <meta http-equiv="Content-Type" contect="text/html" charset="utf-8">
    <title>TodoList</title>
    <script src="<c:url value="/js/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <link rel="stylesheet" href="<c:url value="/js/bootstrap/dist/css/bootstrap.min.css" />"/>
</head>
<body>

<h1>Try Login!</h1>

<form action="/user/doLogin" method="post">
    <strong>Username:</strong><input name="userName" type="text" value="root" /> <br/>
    <strong>Password:</strong><input name="password" type="text" value="123" /> <br/>
    <input class="btn btn-primary" type="submit" value="login" />
</form>

</body>
</html>
