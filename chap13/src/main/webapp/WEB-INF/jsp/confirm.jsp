<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${nextURL == 'createDone'}">
  <c:set var="h2_text" value="新規社員登録・確認" />
  <c:set var="gobackURL" value="createInput" />
  <c:set var="btn_text" value="登録" />
</c:if>
  
<c:if test="${nextURL == 'updateDone'}">
  <c:set var="h2_text" value="社員情報・確認" />
  <c:set var="gobackURL" value="updateInput" />
  <c:set var="btn_text" value="更新" />
</c:if>
  
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
  <jsp:include page="common/header.jsp" />
  
  <div class="container">
    <main>
      <h2>${h2_text}</h2>
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
      
      <form action="${nextURL}" method="post">
        <input type="hidden" name="id" value="${emp.id}">
        <input type="hidden" name="name" value="${emp.name}">
        <input type="hidden" name="age" value="${emp.age}">
        
        <input type="submit" value="もどる"
               formaction="${gobackURL}" formmethod="post">
        <input type="submit" value="${btn_text}">
      </form>
      
    </main>
    <jsp:include page="common/aside.jsp" />
  </div> <!--.container end-->
  
  <jsp:include page="common/footer.jsp" />
</body>
</html>