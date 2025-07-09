<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
  <h2>サブメニュー</h2>
  <div class="menu-item">
    <form action="#" method="get">
      <input type="submit" value="新規作成">  
    </form>
  </div>
  <div class="menu-item">
    年齢で検索
    <form action="listByAge" method="post">
      <input type="text" name="age">歳以上
      <input type="submit" value="検索">  
    </form>
  </div>
</aside>