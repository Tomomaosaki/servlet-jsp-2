<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp" />
<body>
  <jsp:include page="../common/header.jsp" />
  
  <div class="container">
    <main>
      <h2>新規社員登録・確認</h2>
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
          <td><c:out value="${emp.id}" /></td>
        </tr>
        <tr>
          <th>名前</th>
          <td><c:out value="${emp.name}" /></td>
        </tr>
        <tr>
          <th>年齢</th>
          <td><c:out value="${emp.age}" /></td>
        </tr>        
      </table>
      
      <form action="createDone" method="post">
        <input type="hidden" name="id" value="${emp.id}">
        <input type="hidden" name="name" value="${emp.name}">
        <input type="hidden" name="age" value="${emp.age}">
        
        <input type="submit" value="もどる"
               formaction="createInput" formmethod="post">
        <input type="submit" value="登録">
      </form>
      
    </main>
    <jsp:include page="../common/aside.jsp" />
  </div> <!--.container end-->
  
  <jsp:include page="../common/footer.jsp" />
</body>
</html>