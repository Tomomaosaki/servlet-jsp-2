<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body id="list">
  <jsp:include page="common/header.jsp" />
  
  <div class="container">
    <main>
    <h2>社員一覧</h2>
    <div class="error">
      <ul>
        <c:forEach var="errorMsg" items="${errorList}">
          <li><c:out value="${errorMsg}" /></li>
        </c:forEach>
      </ul>
    </div>
    <table>
      <tr>
        <th>ID</th>
        <th>名前</th>
        <th>年齢</th>
        <th class="no-border no-bk"></th>
        <th class="no-border no-bk"></th>
      </tr>
  
        <c:forEach var="emp" items="${empList}">
          <tr>
            <td><c:out value="${emp.id}" /></td>
            <td><c:out value="${emp.name}" /></td>
            <td><c:out value="${emp.age}" /></td>
            <td class="no-border">
              <form action="updateInput" method="get">
                <input type="hidden" name="id" value="${emp.id}">
                <input type="submit" value="編集">
              </form>
            </td>
            <td class="no-border">
              <form action="#" method="post">
                <input type="hidden" name="id" value="${emp.id}">
                <input type="submit" value="削除">
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
    </main>
    <jsp:include page="common/aside.jsp" />
  </div> <!--.container end-->
  
  <jsp:include page="common/footer.jsp" />
</body>
</html>