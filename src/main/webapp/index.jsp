<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリログイン</title>
<style>
.error{
	color: red;
}
</style>
</head>
<body>
<form action="LoginServlet" method="POST">
<h1>TODOアプリケーション</h1>
<h2>ログイン</h2>
<p class="error">${errorMsg}</p>
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>