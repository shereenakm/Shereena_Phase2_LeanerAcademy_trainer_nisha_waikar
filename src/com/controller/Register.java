package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.AdminDao;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		if(username.length()==0&&password.length()==0) {	
			RequestDispatcher sd = null;
			sd = request.getRequestDispatcher("update_admin.html");
			sd.include(request,response);
			out.println("<h2>fields or empty <h2>");
			out.println("<h2>Enter username and passwaord<h2>");
		}
		else {
			AdminDao d = new AdminDao();
			d.updateadmin(username, password);
			rd = request.getRequestDispatcher("index.html");
			rd.include(request,response);
			out.println("<h2>New username and password updated sucessfully<h2>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
