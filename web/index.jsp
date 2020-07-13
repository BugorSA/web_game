<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>NetCracker</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Добро пожаловать в игру Бык-Корова</h1>
<form method="post">
  <ol class="rounded">
    <li><a><label>
      <input name="mainchoice" type="radio" value="1" checked>
    </label>Начать новую игру</a></li>
    <li><a><label>
      <input name="mainchoice" type="radio" value="2">
    </label>Статистика</a></li>
    <li><a><label>
      <input name="mainchoice" type="radio" value="3">
    </label>Выход</a></li>
    <input type="submit" value="Выбрать">
  </ol>
</form>
</body>
</html>