<%@page import="model.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import=" java.util.Date,java.text.SimpleDateFormat, java.io.PrintWriter" %>
<%
Todo todo=(Todo) request.getAttribute("todo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
<link rel="shortcut icon" href="images/favicon.ico">
<style>
.msg{
	color: red;
}
</style>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>${loginUser.name}のTODOリスト</h2>
<p class="msg">${msg}</p>
<table border="1">
<tr>
<th>NO</th><th>重要度</th><th>内容</th><th>期日</th>
</tr>
<tr>
<td>1</td><td>${todo.numbers}</td><td>${todo.contents}</td><td>${todo.limitDay}</td>
</tr>
</table><br>

<form action="UpdateServlet" method="POST">
変更NO
<select name="no">
<option value="1">1</option>
</select>
<select name="Numbers">
<option value="" selected></option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>

<input type="text" name="Contents">

<input type="date" name="limitDay">
<input type="submit" value=変更>
</form>
<form action="RemoveServlet" method="POST">
削除NO
<select name="no">
<option value="1">1</option>
</select>
<input type="submit" value="削除">
</form>
<form action="InputServlet" method="GET">
<button onclick="history.back();">戻る</button>
</form>
</body>
</html>