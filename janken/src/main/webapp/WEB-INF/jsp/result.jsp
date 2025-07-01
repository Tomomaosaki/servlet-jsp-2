<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
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
    <p><%= msg %></p>
    <p><a href="play">もう一度</a></p>
  </main>
  
  <footer>
    <small>&copy; 2025 KAWAMOTO</small>
  </footer>
</body>

</html>