<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "WEB-INF/jsp/title.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= title %></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
<div class="usualPage">
<h1>Добро пожаловать на курс Java!</h1>
	<p>Здесь вы найдёте всё, что нужно для изучения Java от начального
		до продвинутого уровня.</p>
<form action="Controller" method="get">
	 <button type="submit" name="command" value="GO_TO_AUTHENTIFICATION_PAGE">Войти / Регистрация</button>
</form>
	
<%@ include file="WEB-INF/jsp/footer.jsp" %>
</div>
</body>
</html>