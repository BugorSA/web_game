<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Бык-Корова</title>
</head>
<body>
<ol class="rounded">
  <%--@elvariable id="logs" type="java.util.List"--%>
  <c:forEach var = "log" items="${logs}">
    <li><a><c:out value="${log}"/></a></li>
  </c:forEach>
  <p>: ${name}</p>
</ol>
<form method="post" action="hello">
  <label>
    <select name="select1" size="3">
      <option selected="selected"></option>
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      <option>6</option>
      <option>7</option>
      <option>8</option>
      <option>9</option>
      <option>0</option>
    </select>
  </label>
  <select name="select2" size="3">
    <option selected="selected"></option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>0</option>
  </select>
  <select name="select3" size="3">
    <option selected="selected"></option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>0</option>
  </select>
  <select name="select4" size="3">
    <option selected="selected"></option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>0</option>
  </select>
  <input type="submit" value="Выбрать">
</form>
</body>
</html>