package com.MyServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.MyClass.ExecuteQuery;
import com.MyClass.User;


public class registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name, email, password;
		int uid=0;
		name = request.getParameter("name");
		email = request.getParameter("email");
		long number = Long.parseLong(request.getParameter("contact"));
		password = request.getParameter("password");
		User reg_user = new User(name, email, number, password);
		int flag = ExecuteQuery.insert(reg_user);
		if(flag>0) {
			uid = ExecuteQuery.user_id(Long.parseLong(request.getParameter("contact")));
			response.sendRedirect("registration.jsp?uid=" + uid);
		}else response.sendRedirect("registration.jsp?uid=" + 0);
	}
}
