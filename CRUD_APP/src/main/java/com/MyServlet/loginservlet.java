package com.MyServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.MyClass.ExecuteQuery;
import com.MyClass.User;

//import com.MyClass.User;

public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		String uid = request.getParameter("uid");
		String contact = request.getParameter("contact");
		String pass = request.getParameter("password");
		if(uid.length()==0 && contact.length()!=0) {
			long num = Long.parseLong(contact);
			User log_user = new User(num, pass);
			flag = ExecuteQuery.login(log_user);
		}else if(uid.length()!=0){
			int id = Integer.parseInt(uid);
			User log_user = new User(id, pass);
			flag = ExecuteQuery.login(log_user);
		}
		if(flag == true) {
			String name = ExecuteQuery.name(pass);
			HttpSession create_session = request.getSession();
			create_session.setAttribute("name", name.toUpperCase());
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp?error=0");
		}
	}
}
