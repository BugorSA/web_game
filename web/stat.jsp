<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Статистика</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
Среднее число попыток: <%=request.getAttribute("average")%>
<br> Кол-во попыток до победы:
<ol class="rounded">
    <%--@elvariable id="stats" type="java.util.List<model.Game>"--%>
    <c:forEach var = "game" items="${stats}">
        <li><a><c:out value="${game.num_try}"/></a></li>
    </c:forEach>
</ol>
<a href="${pageContext.request.contextPath}/hello"> Вернуться в меню </a>
<br> <br> Рейтинг игроков:
<ol class="rounded">
    <%--@elvariable id="listPlayer" type="java.util.List<java.lang.String>"--%>
    <c:forEach var = "player" items="${listPlayer}">
        <li><a><c:out value="${player}"/></a></li>
    </c:forEach>
</ol>
</body>
</html>
