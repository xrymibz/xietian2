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
		var name = th.userAccount.value;
		alert(name);
		var hash = hex_md5(name);
		alert("加密后的密码"+hash)

	}
</script>


<title>注册界面</title>
</head>
<body>
	<form name="form2" action="<%=path%>/register/commit" method="post">

		<div align="center">
			账户名: <input type="text" name="userAccount"> <br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="text" name="userPassword">
			<br> 姓&nbsp;&nbsp;&nbsp;&nbsp;名: <input type="text"
				name="userName"> <br> 邮&nbsp;&nbsp;&nbsp;&nbsp;箱: <input
				type="text" name="userAge">
		</div>
		<div align="center">
			<input type="button" name="commit" onclick="check()" value="提交" /> <input
				type="button" name="goback"
				onclick="javascript:location.href='<%=path%>/register/back'"
				value="返回" />

		</div>
	</form>


</body>
</html>