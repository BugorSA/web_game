<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>NetCracker</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Добро пожаловать в игру Бык-Корова</h1>
<form method="post" action="hello">
    <ol class="rounded">
        <li><a><label>
        <input name="mainChoice" type="radio" value="new game" checked>
        </label>Начать новую игру</a></li>
        <li><a><label>
            <input name="mainChoice" type="radio" value="stat">
        </label>Статистика</a></li>
        <li><a><label>
            <input name="mainChoice" type="radio" value="exit">
        </label>Выход</a></li>
        <input type="submit" name="go" value="Выбрать">
    </ol>
</form>
</body>
</html>