<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TodoList</title>
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
