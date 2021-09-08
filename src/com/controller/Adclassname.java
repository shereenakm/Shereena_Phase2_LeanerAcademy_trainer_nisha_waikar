package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ClassesDao;
import com.Dao.ListDao;
import com.Dao.StudentDao;
import com.Dao.SubjectsDao;
import com.Dao.TeachersDao;
import com.bean.Classes;

public class Adclassname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Adclassname() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		int option = 0;
		try {
			option = Integer.parseInt(request.getParameter("switch"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
		}
		ClassesDao cls1 = new ClassesDao();
		StudentDao st1 = new StudentDao();
		SubjectsDao sub1 =new SubjectsDao();
		TeachersDao teach1 = new TeachersDao();
	
		
	switch(option) {
	case 1:
		
	{
		String classname = request.getParameter("cname");
		
		if(classname.length()==0){
			response.sendRedirect("AdminDashboard.jsp");
		}else {
			cls1.addclasses(classname);
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
			rd.include(request, response);
			out.println("<h3>New class added sucessfully</h3> ");
			
		}
		rd = request.getRequestDispatcher("AdminDashboard.jsp");
		
	}	
	break;
	case 2:
	{
		String subjectname = request.getParameter("sname");
		if(subjectname.length()==0)
		{
			response.sendRedirect("AdminDashboard.jsp");
		}else {
			
			sub1.addsubject(subjectname);
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
			rd.include(request, response);
			out.println("<h3>New subject added sucessfully</h3>");
		
		}
		
	}
	break;
	case 3:
	{	
		
		String teachername = request.getParameter("tname");
		if(teachername.length()==0)
		{
			response.sendRedirect("AdminDashboard.jsp");
		}else {
			teach1.addteacher(teachername);
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
			rd.include(request, response);
			out.println("<h3>New teacher added sucessfully</h3>");
			
		}
		
	}
	
	break;
	case 4:
{	
		//add student assign to class
		try {
			String studentname = request.getParameter("student");
			int classid4 = Integer.parseInt(request.getParameter("classid"));
			if(studentname.length()==0&&classid4==0)
			{
				response.sendRedirect("AdminDashboard.jsp");
			}else {
				st1.addstudenttoclass(studentname, classid4);
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.include(request, response);
				out.println("<h3>student Assigned to class sucessfully</h3>");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
		}
	}
break;
	case 5:	
{	
		
		try {
			int classid5 = 	Integer.parseInt(request.getParameter("classid2s"));
			int subjectid5 = Integer.parseInt(request.getParameter("subjectid2c"));
			System.out.println(classid5+"fgghgjh"+subjectid5);
			if(subjectid5==0&&classid5==0)
			{
				response.sendRedirect("AdminDashboard.jsp");
			}else {
				sub1.subject_class(subjectid5, classid5);
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.include(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
		}
	}
break;
	case 6:
{	
		
		try {
			int subid6 =Integer.parseInt(request.getParameter("subjectid2techer"));
			int teachid6 =Integer.parseInt(request.getParameter("teacherid2sub"));
			if(subid6==0&&teachid6==0)
			{
				response.sendRedirect("AdminDashboard.jsp");
			}else {
				sub1.subject_teacher(subid6, teachid6);
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.include(request, response);
				out.println("<h3>subject Assigned to Teacher sucessfully</h3>");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
		}
		
	}
break;
	case 7:
{	
		
		try {
			int techerid7 = Integer.parseInt(request.getParameter("teacher2cls"));
			int classid7 = Integer.parseInt(request.getParameter("classid2teach"));
			if(techerid7==0&&classid7==0)
			{
				response.sendRedirect("AdminDashboard.jsp");
			}else {
				teach1.teacher_class(techerid7,classid7);
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.include(request, response);
				out.println("<h3>subject Assigned to Teacher sucessfully</h3>");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			rd = request.getRequestDispatcher("AdminDashboard.jsp");
		}
	}

break;
	default:rd = request.getRequestDispatcher("AdminDashboard.jsp");
	}
	}
	}

