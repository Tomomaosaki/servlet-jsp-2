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
      <h2>新規社員登録・結果</h2>
      <div class="error">
        <ul>
          <c:forEach var="errorMsg" items="${errorList}">
            <li><c:out value="${errorMsg}" /></li>
          </c:forEach>
        </ul>
      </div>
      <p><c:out value="${msg}" /></p>
      <p><a href="list"><button type="button">一覧へ</button></a></p>
    </main>
    <jsp:include page="../common/aside.jsp" />
  </div> <!--.container end-->
  
  <jsp:include page="../common/footer.jsp" />
</body>
</html>