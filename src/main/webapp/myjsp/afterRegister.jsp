<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
	String path = request.getContextPath();
	String basePatt = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String isSame = (String)request.getAttribute("isSame");  
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

var th = document.form1;
var fm = '<%=isSame%>';


if(fm=="yes"){

	alert("该账户已被注册，请重新注册");
	window.location.href = "<%=path%>/afterRegister/yes";

	
	}else{
		alert("恭喜您，注册成功");
		window.location.href = "<%=path%>/afterRegister/no";
	}

</script>
</head>
<body>

<form name="form1" value="afterRegister">


</form>
</body>
</html>