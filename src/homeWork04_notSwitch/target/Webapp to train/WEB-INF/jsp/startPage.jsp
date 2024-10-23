<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "title.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= title %></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
<div class="backgroundFrame">
<h1>Добро пожаловать в курс Java!</h1>
<p>Поздравляем, <%= request.getAttribute("email") != null ? request.getAttribute("email") : "гость" %>, с успешным входом на платформу. Вы готовы начать изучение?</p>
<div class="chooseButton">
<form action="Controller" method = "get">
<button type = "submit" name = "command" value = "SHOW_STUB" class="leftButton">Перейти к урокам</button>
</form>
<form action="Controller" method = "get">
<button type = "submit" name = "command" value = "SHOW_STUB" class="rightButton">Мой профиль</button>
</form>
</div>
<%@ include file = "footer.jsp" %>
</div>
</body>
</html>