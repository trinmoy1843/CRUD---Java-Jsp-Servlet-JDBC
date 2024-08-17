<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.MyClass.ExecuteQuery" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			.input{
				width : 900px;
				margin : 4px;
				padding : 5px;
			}
			.id{
				width : 100px;
			}
			table, th, td {
  				border:1px solid black;
			}
			td, th{
				width : 200px;
			}
		</style>
	</head>
	<body>
		<%ResultSet rs = ExecuteQuery.display_table();%>
		<table>
			<tr>
				<th class="id">USERID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT NUMBER</th>
				<th>PASSWORD</th>
			</tr>
			<%while(rs.next()){%>
				<tr>
					<td class="id"><% out.print(rs.getString("uid")); %></td>
					<td><% out.print(rs.getString("name")); %></td>
					<td><% out.print(rs.getString("email")); %></td>
					<td><% out.print(rs.getString("contact")); %></td>
					<td><% out.print(rs.getString("password")); %></td>
				</tr>
			<%}%>
		</table>

		<form action="index.jsp">
			<button type="submit" class="input">HOME</button>
		</form>
	</body>
</html>