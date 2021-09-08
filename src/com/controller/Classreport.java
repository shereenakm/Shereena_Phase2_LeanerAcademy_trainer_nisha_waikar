package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ClassesDao;
import com.bean.Classes;


public class Classreport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Classreport() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classid = Integer.parseInt(request.getParameter("classid8"));
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if(classid==0){
			response.sendRedirect("AdminDashboard.jsp");
		}else {
			ClassesDao clsDao = new ClassesDao();
			Classes classes =clsDao.giveclass(classid);
			session.setAttribute("report",classes);
			response.sendRedirect("Report.jsp");	
		}
		rd = request.getRequestDispatcher("AdminDashboard.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
