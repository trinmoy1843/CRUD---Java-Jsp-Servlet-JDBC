package com.MyServlet;

import java.io.IOException;

import com.MyClass.ExecuteQuery;
import com.MyClass.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		User log_user = null;
		String uid = request.getParameter("uid");
		String contact = request.getParameter("contact");
		String pass = request.getParameter("password");
		if(uid.length()==0 && contact.length()!=0) {
			long num = Long.parseLong(contact);
			log_user = new User(num, pass);
			flag = ExecuteQuery.login(log_user);
		}else if(uid.length()!=0){
			int id = Integer.parseInt(uid);
			log_user = new User(id, pass);
			flag = ExecuteQuery.login(log_user);
		}
		if(flag == true) {
			boolean check = ExecuteQuery.del_profile(log_user);
			if(check==true) response.sendRedirect("delete.jsp?error=false");
			else response.sendRedirect("delete.jsp?error=true");
		}else {
			response.sendRedirect("delete.jsp?error=login");
		}
	}

}
