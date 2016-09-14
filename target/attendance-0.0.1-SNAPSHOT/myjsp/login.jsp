<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%
String path =request.getContextPath();
String basePatt = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String what = (String)request.getAttribute("sign");  



%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>617备忘录</title>

<script type="text/javascript">

var th = '<%=what%>';



if(th=="notPass"){
alert("密码错误，请重新输入")
}






</script>

</head>
<body>

<div  id ="judge" value="${sign }"></div>
	欢迎登录617备忘录
	<form id="submit" action="login">
		<table border="1" width="300" id="info" align="center">

			<tr align="center">
				<td>账户</td>
				<td><input type="text" name="account" /></td>
			</tr>

			<tr align="center">
				<td>密码</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
		</table>
		<div align="center">  
			<input  align="middle" type="submit" name="submit" value="登录" />
			<input  align="middle" type="submit" name="logup" value="注册" />
		</div>
	</form>
</body>
</html>