<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User registerUser =(User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
  <h1>ユーザー登録・確認</h1>
  <p>下記のユーザーを登録します</p>
  <p>
  ログインID：<%= registerUser.getId() %><br>
  名前：<%= registerUser.getName() %><br>
  </p>
  <p>
  <a href="RegisterUser">もどる</a>
  <a href="RegisterUser?action=done">登録</a>
  </p>
</body>
</html>