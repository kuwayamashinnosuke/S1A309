<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import=" java.util.Date,java.text.SimpleDateFormat, java.io.PrintWriter" %>
<%
String[]todoList= {"Linuxテスト対策","paiza","TODOアプリ作成","履歴書作成"};


Date date=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
String limitDay=sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>桑山慎之助のTODOリスト</h2>
<table border=1>
<tr>
<th>NO</th><th>重要度</th><th>内容</th><th>期日</th>
</tr>
<% for(int i=0;i<10;i++){
//内容
int index=(int)(Math.random()*4);
String todo=todoList[index];
//重要度
int priority=index+1;
%>
<tr>
<td><%=i+1 %></td><td><%=priority %></td><td><%=todo %></td><td><%=limitDay %></td>
</tr>
<%}%>
</table>
</body>
</html>