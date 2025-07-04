<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GameManager" %>
<%
GameManager manager = (GameManager)request.getAttribute("manager");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>じゃんけんゲーム</title>
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
  <header>
    <h1>じゃんけんゲーム</h1>
  </header>
  
  <main>
    <p><%= manager.getHands() %></p>
    <p><%= manager.getResult() %></p>
    <p><a href="play">もう一度</a></p>
  </main>
  
  <footer>
    <small>&copy; 2025 KAWAMOTO</small>
  </footer>
</body>

</html>