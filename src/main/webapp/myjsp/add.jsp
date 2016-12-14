<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.modelPO.UserVO" %>	

<%
String path =request.getContextPath();
%>
<%List<UserVO>list = (List<UserVO>)request.getAttribute("userAll");
int totalPage = (Integer)request.getAttribute("totalPage");  //總的頁面數
int currentPage = (Integer)request.getAttribute("currentPage"); //当前页面
int pageSize = (Integer)request.getAttribute("pageSize");;  //每页条数
int totalNum = (Integer)request.getAttribute("totalNum");; //总的数据数量
int startNum = currentPage*pageSize; //开始的数据序号
int nextPage = 0;  //下一页
int previousPage = 0; //上一页
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>备忘录</title>
<script type="text/javascript">


function nextPage(){

	var th = document.form2;
	th.currentPages.value=<%=currentPage+1%>;
	th.action="<%=path%>/add";
		th.submit();
}
	
function previousPage(){
	var th = document.form2;
	th.currentPages.value=<%=currentPage-1%>;
	th.action="<%=path%>/add";
		th.submit();
}



</script>


</head>
<body>

<form name="form2" action="login" method="post">
<input type="hidden"   name="currentPages" value=""/>
<h2 align="center">备忘录</h2>>
<div class = "container">
	<table  class="table table-bordered" border="1"  width="400" align="center">

		<tr   id="info" align="center">
			<td>姓名</td>
			<td>生日</td>
			<td>今年</td>
		</tr>

		<!--  >tr align="center">
			<td>${user.name }</td>
			<td>${user.birthday }</td>
			<td>${user.salary }</td>
		</tr-->
		
		<%for (int i=startNum ;i < startNum+pageSize;i++) { %>
		<tr align="center">
		   	<td><%=list.get(i).getName()  %></td>
			<td><%=list.get(i).getBirthday() %></td>
			<td><%=list.get(i).getSalary() %></td>
		
		</tr>
		<%} %>
		
		


	</table>
</div>
	</form>
	<div align="center">
	<input class = "btn btn-default" align="middle" type="button" name="denglu" onclick="javascript:location.href='<%=path%>/login/login'"  value="退出" />
	<input  class = "btn btn-default" align="middle" type="button" name=previousPage onclick="previousPage()"  value="上一页" />
	<input  class = "btn btn-default" align="middle" type="button" name="nextPage" onclick="nextPage()"  value="下一页" />
	</div>
</body>
</html>