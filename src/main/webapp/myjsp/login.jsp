<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%
	String path = request.getContextPath();
	String basePatt = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String what = (String) request.getAttribute("sign");
%>

<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 617备忘录</title>
<link rel="stylesheet"
	href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>617备忘录</title>
<script type="text/ecmascript" src="/xietian2/properties/md5.js"></script>
<script type="text/javascript">
	var fm = '<%=what%>';
	if(fm=="notPass"){
		alert("密码错误，请重新输入"+fm)
		}

function login(){
	
var th = document.form1;
var pwd = th.pwd.value;
if(th.account.value==""){
	alert("账号不能为空")
	return;
}else if(th.pwd.value==""){
	alert("密码不能为空")
	return;
}
	
var hash = hex_md5(pwd);
th.hashpwd.value=hash;	
	
th.action="<%=path%>/login/login"
		th.submit();
	}
</script>

</head>
<body>


	<div class="text-primary" >

		<h1 align="center">欢迎登录617备忘录</h1>
	</div>

<div class="container">

<div class = "row">
<div class = "col-sm-4 col-sm-offset-4 form-box">
	<form name="form1" action="login" method="post">



		<div class="input-group" >
			<span class="input-group-addon">账号</span> <input type="text"
				name="account" class="form-control">
		</div>
		<div>
		
		</div>
		<div class="input-group">
			<span class="input-group-addon">密码</span> <input type="password"
				name="pwd" class="form-control">
		</div>

		<div align="center">
			<input align="middle" class="btn btn-default" type="button"
				name="denglu" onclick="login()" value="登录" /> <input align="middle"
				class="btn btn-default" type="button" name="logup"
				onclick="javascript:location.href='<%=path%>/login/register'"
				value="注册" /> <input type="hidden" name="hashpwd" value="" />
		</div>
	</form>
	</div>
	</div>
	</div>
</body>
</html>