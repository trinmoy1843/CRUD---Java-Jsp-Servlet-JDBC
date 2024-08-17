<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>UPDATE A EXISTING PROFILE</title>
		<style>
			.input{
				width : 500px;
				margin : 4px;
				padding : 5px;
			}
			.failed{
				color : red;
			}
			h4{
				color : blue;
			}
		</style>
	</head>
	<body>
		<%
			String flag = request.getParameter("error");
			if(flag != null){
				if(flag.equals("false")){
					%><h3 class="succes">PROFILE UPDATED SUCCESFULLY</h3><%
				}
				if(flag.equals("login")){
					%><h3 class="failed">ENTER CORRECT EXISTING DETAILS</h3><%
				}
				if(flag.equals("name")){
					%><h3 class="failed">NAME IS NOT UPDATED, ENTER CORRECT FORMAT</h3><%
				}
				if(flag.equals("email")){
					%><h3 class="failed">EMAIL IS NOT UPDATED, ENTER CORRECT FORMAT</h3><%
				}
				if(flag.equals("contact")){
					%><h3 class="failed">CONTACT IS NOT UPDATED, ENTER CORRECT FORMAT OR THE NUMBER ENTERED ALREADY EXISTS</h3><%
				}
				if(flag.equals("password")){
					%><h3 class="failed">PASSWORD IS NOT UPDATED, ENTER CORRECT FORMAT</h3><%
				}
			}
		%>
		<form action="updateservlet" method="post">
			<h4>** USER ID CANNOT BE UPDATED</h4>
			<input type="text" name="uid" placeholder="ENTER YOUR USER ID" class="input" required><br>
			<input type="text" name="name" placeholder="ENTER NEW NAME" class="input"><br>
			<input type="text" name="email" placeholder="ENTER NEW EMAIL" class="input" ><br>
			<input type="text" name="contact" placeholder="ENTER YOUR NEW CONTACT NUMBER" class="input"><br>
			<input type="password" name="newpassword" placeholder="ENTER YOUR NEW PASSWORD" class="input"><br>
			<input type="password" name="oldpassword" placeholder="ENTER YOUR EXISTING PASSWORD" class="input" required><br>
			<button type="submit" class="input">UPDATE</button>	
		</form>
		<form action="index.jsp">
			<button type="submit" class="input">HOME</button>
		</form>
	</body>
</html>