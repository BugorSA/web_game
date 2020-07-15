<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>

<div id="wrapper" class="form">

    <h1>Вход в систему</h1><br>
    <form id="signin" method="post" action="" autocomplete="off">
        <input type="text" id="user" required placeholder="login" name="login">
        <input type="password" id="pass" required placeholder="password" name="password">
        <button type="submit">&#xf0da;</button>
        <p>Зарегистрироваться <a href="registration">click here</a></p>
    </form>
</div>
</body>
</html>
