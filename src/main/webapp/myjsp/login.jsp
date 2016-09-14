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
	var fm = '<%=what%>';
	if(fm=="notPass"){
		alert("密码错误，请重新输入")
		}

function login(){
var th = document.form1;
if(th.account.value==""){
	alert("账号不能为空")
	return;
}else if(th.pwd.value==""){
	alert("密码不能为空")
	return;
}
th.action="<%=path%>/login/login"

th.submit();
}


</script>

</head>
<body>


	欢迎登录617备忘录
	<form name="form1" action="login" method="post">
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
			<input  align="middle" type="button" name="denglu" onclick="login()"value="登录" />
			<input  align="middle" type="button" name="logup"  onclick="javascript:location.href='<%=path%>/login/register'" value="注册" />

		</div>
	</form>
</body>
</html>