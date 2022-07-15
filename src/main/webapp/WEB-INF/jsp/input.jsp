<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
String[]todoList= {"Linuxテスト対策","paiza","TODOアプリ作成","履歴書作成"};
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ入力画面</title>
<link rel="shortcut icon" href="images/favicon.ico">
</head>
<script type="text/javascript">
<!--
function check(){
	var flag=0;
	if(document.form1.Number.value==""){
		flag=1;
	}
	else if(document.form1.Contents.value==""){
		flag=1;
	}
	else if(document.form1.limitDay.value==""){
		flag=1;
	}
	if(flag){
		window.alert('項目に未入力がありました');
		return false;
	}
	else{
		return true;
	}
}

</script>
<style>
.error{
	color: red;
}
</style>
<body>


<form action="/S2A116/InputServlet" method="post" name="form1" onsubmit="return check()" >
<h1>TODOアプリケーション</h1>
<h2>TODOの入力</h2>

<p class="error">${msg}</p>


重要度:
<select name="Numbers">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select><br>
内容:
<input type="text" name="Contents"><br>
期日<input type="date" name="limitDay"><br><br>
<input type="submit" value="登録">
</form>
</body>
</html>