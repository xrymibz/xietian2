<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="1"  width="400" align="center">

		<tr   id="info" align="center">
			<td>姓名</td>
			<td>生日</td>
			<td>薪水</td>
		</tr>

		<tr align="center">
			<td>${user.name }</td>
			<td>${user.birthday }</td>
			<td>${user.salary }</td>
		</tr>


	</table>

</body>
</html>