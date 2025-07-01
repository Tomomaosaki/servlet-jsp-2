<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <p>選んでください</p>
    <form action="play" method="post">
      <button type="submit" name="hand" value="0">
        <img src="img/gu.png" alt="グー">
      </button>
      <button type="submit" name="hand" value="1">
        <img src="img/choki.png" alt="チョキ">
      </button>
      <button type="submit" name="hand" value="2">
        <img src="img/pa.png" alt="パー">
      </button>
    </form>
  </main>
  
  <footer>
    <small>&copy; 2025 KAWAMOTO</small>
  </footer>
</body>

</html>