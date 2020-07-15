<%--@elvariable id="num" type="java.lang.String"--%>
<%--@elvariable id="try" type="java.lang.String"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Победа</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1> Вы выйграли! </h1>
Попыток: <%=request.getAttribute("try")%>
Загаданное число: <%=request.getAttribute("num")%>
<a href="${pageContext.request.contextPath}/hello">Вернуться</a>
</body>
</html>