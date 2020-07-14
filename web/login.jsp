<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

    <div class="form">

        <h1>Вход в систему</h1><br>
        <form method="post" action="">

            <label>
                <input type="text" required placeholder="login" name="login">
            </label><br>
            <label>
                <input type="password" required placeholder="password" name="password">
            </label><br><br>
            <input class="button" type="submit" value="Войти">

        </form>
        <a href="registration.jsp">Зарегистрироваться</a>
    </div>
</body>
</html>
