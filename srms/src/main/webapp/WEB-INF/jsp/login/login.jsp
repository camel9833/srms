<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.company.Controller.LoginManager"%>
<%
    LoginManager loginManager = LoginManager.getInstance(); 
	session.removeAttribute("userId");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<script>
	function btn_click() {
		var f = document.loginForm; //폼 name

		f.action = "loginCheck.do"; //이동할 페이지
		f.method = "post"; //POST방식
		f.submit();
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
<title>Home</title>
</head>

<body>
	<form name="loginForm">

		<h1>SRMS</h1>
		<table border="0" width="400px">
		    <tr>
		    	<td>현재 접속자 수 </td>
		    	<td><%=loginManager.getUserCount()%>명</td>
		    </tr>
		

			<tr>
				<td>아이디</td>
				<td><input type='text' name="userId" id="userId" value="test01"></td>
			</tr>

			<tr>
				<td>패스워드</td>
				<td><input type="password" name="userPw" id="userPw" value="1234"></td>
			</tr>

			<tr>
				<input type='button' id="btn01"  name="btn01" value='로그인' onClick='javascript:btn_click();' />
			</tr>
			
			<tr><input type='text' id="testTmp"  name="testTmp"  value='${msg}' /></tr>
		</table>

	</form>
</body>


</html>