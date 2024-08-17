<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>WELCOME</title>
		<style>
			.success{
				color : green;
			}
			.logout{
				width : 300px;
			}
		</style>
	</head>
	<body>
		<%
			HttpSession create_session = request.getSession();
			String name = (String)create_session.getAttribute("name");
		%>
		<h2 class="success">WELCOME <%out.print(name);%>, LOGIN SUCCESSFULL</h2>
		<form action="index.jsp">
			<button type="submit" class="logout">LOGOUT</button>
		</form>
	</body>
</html>