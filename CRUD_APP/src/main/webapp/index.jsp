<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HOME PAGE</title>
		<style>
			.home{
				margin : 4px;
				padding : 5px;
			}
		</style>
	</head>
	<body>
		<%
			HttpSession create_session = request.getSession(false);
			if(create_session != null){
				create_session.invalidate();
			}
		%>
		<a href="login.jsp" class="home">LOGIN</a><br>
		<a href="registration.jsp" class="home">REGISTRATION</a><br>
		<a href="update.jsp" class="home">UPDATE EXISTING PROFILE</a><br>
		<a href="delete.jsp" class="home">DELETE EXISTING PROFILE</a><br>
		<a href="output.jsp" class="home">DISPLAY DATABASE</a>
	</body>
</html>