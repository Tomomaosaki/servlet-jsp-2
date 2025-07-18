<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理プログラム</title>
</head>
<body>
  <h1>社員情報管理プログラム</h1>
  <main>
    <table>
      <tr>
        <th>ID</th>
        <th>名前</th>
        <th>年齢</th>
        <th>誕生日</th>
      </tr>
      <c:forEach var="member" items="${memberList}">
        <tr>
          <td><c:out value="${member.id}" /></td>
          <td><c:out value="${member.name}" /></td>
          <td><c:out value="${member.age}" /></td>
          <td><c:out value="${member.birthday}" /></td>
        </tr>
      </c:forEach>
    </table>   
  </main>
</body>
</html>