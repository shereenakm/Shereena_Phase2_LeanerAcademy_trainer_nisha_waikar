<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.bean.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Report</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 50%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
	<%
if(session.getAttribute("user")==null)
response.sendRedirect("index.html");
%>
<body>
<div align="center">
<h1>CLASS REPORT</h1>
<%!
	List<Student> studlist = new ArrayList<Student>();
	List<Subjects> sublist =new ArrayList<Subjects>();
	List<Teachers> teachlist = new ArrayList<Teachers>();
%>
<% Classes classes =(Classes)session.getAttribute("report"); 


	studlist=classes.getStudent();
	teachlist=classes.getTeacher();
	sublist=classes.getSubjectList();

%>
<H3>List of Students in the class:<%out.println(classes.getClassid()); %>Class Name :<%out.println(classes.getClassname());%></H3>
<table cellspacing="2" cellpadding="2">
		<tr><th>STUDENT ID</th><th>STUDENT NMAE</th><th>CLASS NMAE</th></tr>
		<%
			 for(Student student :studlist) {
				
		     %>
		<tr><td><%=student.getStudentId()%></td>
		<td><%=student.getStudent_name()%></td>
		<td><%=classes.getClassname()%></td>
		</tr>
		<%} %>
		</table>



<H3>List of subjects For class	:<%out.println(classes.getClassid()); %>Class Name :<%out.println(classes.getClassname());%></H3>
<table cellspacing="2" cellpadding="2">
		<tr><th>SUBJECT ID</th><th>SUBJECT NMAE</th></tr>
		<%
			 for(Subjects sub :sublist) {
		     %>
		<tr><td><%=sub.getSubjectid()%></td>
		<td><%=sub.getSubjectname()%></td></tr>
		<%} %>
		</table>




<H3>List Teachers to Teach subjects class ID	:<%out.println(classes.getClassid()); %>Class Name :<%out.println(classes.getClassname());%></H3>
<table cellspacing="2" cellpadding="2">
		<tr><th>TEACHER ID</th><th>TEACHER NMAE</th></tr>
		<%
			 for(Teachers teacher :teachlist) {
		     %>
		<tr><td><%=teacher.getTeacherId()%></td>
		<td><%=teacher.getTeachername()%></td></tr>
		<%} %>
		</table>
<a href=AdminDashboard.jsp>GO back to Admin dashboard page</a><br>
</div>
</body>
</html>