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
<h1>Регистрация нового пользователя</h1>
<main>
<form action = "Controller" method = "post">
<label> <input type = "text" name = "name" placeholder = "Имя пользователя" required></label>
<br>
<label> <input type = "email" name = "email" placeholder = "Email адрес" required></label>
<br>
<label> <input type = "password" name = "password" placeholder = "Пароль" required></label>
<br>
<label> <input type = "password" name = "confirmPassword" placeholder = "Подтверждение пароля" required></label>
<br>
<button type = "submit" name = "command" value = "DO_REGISTRATION">Зарегистрироваться</button>
</form>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>