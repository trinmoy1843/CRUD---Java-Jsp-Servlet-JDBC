package com.MyServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.MyClass.ExecuteQuery;
import com.MyClass.User;

public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String new_pass = request.getParameter("newpassword");
		String old_pass = request.getParameter("oldpassword");
		
		User upd_obj = new User(uid, old_pass);	
		boolean check = ExecuteQuery.login(upd_obj);
		
		if(check == true) {
			if(name.length() != 0) {
				check = ExecuteQuery.upd_name(uid, name);
				if(check == false) response.sendRedirect("update.jsp?error=name");
			}
			if(email.length() != 0) {
				check = ExecuteQuery.upd_email(uid, email);
				if(check == false) response.sendRedirect("update.jsp?error=email");
			}
			if(contact.length() != 0) {
				long number = Long.parseLong(contact);
				check = ExecuteQuery.upd_contact(uid, number);
				if(check == false) response.sendRedirect("update.jsp?error=contact");
			}
			if(new_pass.length() != 0) {
				check = ExecuteQuery.upd_password(uid, new_pass);
				if(check == false) response.sendRedirect("update.jsp?error=password");
			}
			if(check == true) response.sendRedirect("update.jsp?error=false");
		}else {
			response.sendRedirect("update.jsp?error=login");
		}
	}
}
