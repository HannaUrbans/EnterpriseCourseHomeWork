<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<footer>
<hr>
    <%= "@ " + LocalDate.now().getYear() + ". " + request.getAttribute("title") + ". Все права защищены." %>
</footer>