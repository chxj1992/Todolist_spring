<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 1/7/14
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>Try Login!</h1>

<form action="/user/doLogin" method="post">
    <strong>Username:</strong><input name="userName" type="text" value="root" /> <br/>
    <strong>Password:</strong><input name="password" type="text" value="123" /> <br/>
    <input type="submit" value="login" />
</form>

</body>
</html>
