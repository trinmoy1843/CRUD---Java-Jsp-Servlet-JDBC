<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>REGISTER HERE</title>
		<style>
			.input{
				width : 500px;
				margin : 4px;
				padding : 5px;
			}
			.success{
				color : green;
			}
			.failed{
				color : red;
			}
		</style>
	</head>
	<body>
		<%
			String check = request.getParameter("uid");
			if(check != null){
				if(check.equals("0")){%>
					<h3 class="failed">REGISTRATION FAILED</h3>
				<%}else{%>
					<h3 class="success">REGISTRATION SUCCESSFULL, YOUR USER ID IS <% out.print(check);%></h3><%
				}
			}%>
			
		<form action="registrationservlet" method="post">
			<input type="text" name="name" placeholder="ENTER YOUR NAME" class="input" required><br>
			<input type="text" name="email" placeholder="ENTER YOUR EMAIL" class="input" required><br>
			<input type="text" name="contact" placeholder="ENTER YOUR CONTACT NUMBER" class="input" required><br>
			<input type="password" name="password" placeholder="ENTER YOUR PASSWORD" class="input" required><br>
			<button type="submit" class="input">REGISTER</button>	
		</form>
		<form action="index.jsp">
			<button type="submit" class="input">HOME</button>
		</form>
	</body>
</html>