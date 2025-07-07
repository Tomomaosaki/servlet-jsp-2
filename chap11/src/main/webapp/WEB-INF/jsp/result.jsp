<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名前</title>
</head>
<body>
  <p>名前：<%= name %></p>
  <!--  ↓リンクの書き方P484参照-->
  <p><a href="<%= request.getContextPath() %>/">もどる</a></p>
</body>
</html>