<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">Username:
            <input id="username" name="username" type="text">
        </label><br>
        <label for="password">Password:
            <input id="password" name="password" type="password">
        </label><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
