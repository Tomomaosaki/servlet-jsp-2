<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Hero" %>
<%
Hero hero = (Hero)session.getAttribute("hero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero</title>
</head>
<body>
  <p><%= hero.getName() %> : <%= hero.getHp() %></p>
</body>
</html>