<%@page import="model.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import=" java.util.Date,java.text.SimpleDateFormat, java.io.PrintWriter"%>
<%
Todo todo = (Todo) request.getAttribute("todo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
<link rel="shortcut icon" href="images/favicon.ico">
<style>
.msg {
	color: red;
}

.logout {
	text-align: right;
}
</style>
</head>
<body>
	<!-- ログアウト -->
	<div class="logout">
		<a href="LogoutServlet">ログアウト</a>
	</div>
	<h1>TODOアプリケーション</h1>
	<h2>${loginUser.name}のTODOリスト</h2>
	<p class="msg">${msg}</p>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>重要度</th>
			<th>内容</th>
			<th>期日</th>

		</tr>
		<c:forEach var="todo" items="${todoList }" varStatus="status">
			<tr>
				<td id="count">${status.count }</td>
				<td>${todo.numbers}</td>
				<td>${todo.contents}</td>
				<td>${todo.limitDay}</td>
			</tr>
		</c:forEach>
	</table>
	<br>


	<form action="UpdateServlet" method="POST">
		変更NO 
		<select name="status">

			<c:forEach items="${todoList}" varStatus="status">
				<option value="${status.count}">${status.count}</option>
			</c:forEach>

		</select> 
		
		<select name="Numbers">
			<option value="" selected></option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		 <input type="text" name="Contents"> <input type="date"
			name="limitDay"> <input type="submit" value=変更>
	</form>
	<form action="RemoveServlet" method="POST">
		削除NO <select name="no">
		<c:forEach items="${todoList}" varStatus="status">
			<option value="${status.count}">${status.count}</option>
		</c:forEach>

		</select>
		<input type="submit" value="削除">
	</form>
	<form action="InputServlet" method="GET">
		<button onclick="history.back();">戻る</button>
	</form>
</body>
</html>