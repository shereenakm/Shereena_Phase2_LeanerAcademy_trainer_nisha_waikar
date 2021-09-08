package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import com.Dao.AdminDao;
import com.bean.Admin;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDao admindao = new AdminDao();
		//admindao.addadmin(); //to add admin for first time
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		RequestDispatcher rd = null;
		Admin admin ;
		admin= admindao.giveadmin();
		if (username.equalsIgnoreCase(admin.getUsername()) && password.equalsIgnoreCase(admin.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect("AdminDashboard.jsp");
		} else {
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("<h2>username or password invalid</h2>");
			out.println("<h2><a href=/Learners_academy/update_admin.html>click here to update username and password</a></h2>");
		}
	}
}
