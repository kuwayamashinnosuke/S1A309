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
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>桑山慎之助のTODOリスト</h2>
<p>${msg}</p>
<table border="1">
<tr>
<th>NO</th><th>重要度</th><th>内容</th><th>期日</th>
</tr>
<tr>
<td>1</td><td>${todo.numbers}</td><td>${todo.contents}</td><td>${todo.limitDay}</td>
</tr>
</table><br>

<button onclick="history.back();">戻る</button>
</body>
</html>