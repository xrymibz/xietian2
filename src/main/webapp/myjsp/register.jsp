<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePatt = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String what = (String) request.getAttribute("sign");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/ecmascript" src="md5.js"></script>
<script type="text/javascript">
	function check() {

		
		var th = document.form2;
		var pwd = th.userPassword.value;
		if(th.userAccount.value==""){
			alert("用户名不能为空")
			return;
		}else if(th.userPassword.value==""){
			alert("密码不能为空")
			return;
		}else if(th.reuserPassword.value==""){
			alert("确认密码不能为空")
			return;
		}else if(th.userName.value==""){
			alert("姓名不能为空")
			return;
		}else if(th.userEmail.value==""){
			alert("邮箱不能为空")
			return;
		}else if(th.userPassword.value!=th.reuserPassword.value){
			alert("两次密码不一致");
			return;
		}
		
		
		
		var hash = hex_md5(pwd);
		th.hashpwd.value=hash;		
		th.action="<%=path%>/register/commit"
		th.submit();
	}
</script>


<title>注册界面</title>
</head>
<body>
	<form name="form2" action="<%=path%>/register/commit" method="post">

		<div align="center">
			账户名: <input type="text" name="userAccount"> <br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="text" name="userPassword">
			<br> 
			确认密码: <input type="text" name="reuserPassword">
			<br> 
			姓&nbsp;&nbsp;&nbsp;&nbsp;名: <input type="text"
				name="userName">
				<br> 
		            邮&nbsp;&nbsp;&nbsp;&nbsp;箱: <input
				type="text" name="userEmail">
		</div>
		<input type="hidden" name="hashpwd" value=""/>
		<div align="center">
			<input type="button" name="commit" onclick="check()" value="提交" /> <input
				type="button" name="goback"
				onclick="javascript:location.href='<%=path%>/register/back'"
				value="返回" />

		</div>
	</form>


</body>
</html>