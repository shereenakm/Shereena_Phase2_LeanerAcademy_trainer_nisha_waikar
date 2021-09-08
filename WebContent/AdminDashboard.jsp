<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.Dao.ClassesDao"%>
<%@ page import="com.Dao.ListDao"%>
<%@ page import="com.bean.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN DASH BOARD</title>
</head>
<body>
<!--style for tables and option   -->
	<style>     
table {
	border-collapse: collapse;
	width: 50%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}

select {
	width: 25%;
	padding: 16px 16px;
	border: none;
	border-radius: 4px;
	background-color: #f1f1f1;
}
</style>
	<%
		if (session.getAttribute("user") == null)/* verfiy the login of the user  */
			response.sendRedirect("index.html");
	%>
	<h3><a href=index.html>logout</a><br></h3>
	<div align="center">
		<H1>ADMIN DASHBOARD</H1>
	</div><!-- assign list of arrays for list to acces all data to list in the drop down option  -->
	<%!ListDao list = new ListDao();
	List<Classes> clslist = new ArrayList<Classes>();
	List<Student> studlist = new ArrayList<Student>();
	List<Subjects> sublist = new ArrayList<Subjects>();
	List<Teachers> teachlist = new ArrayList<Teachers>();%>
	<%
		clslist = list.classlist();
		studlist = list.studentlist();
		sublist = list.subjectlist();
		teachlist = list.teacherslist();
	%>
	<div align="center">
		<h3>To Add new a Class</h3>
		<form action="Adclassname" method="post">
			Enter the Class Name: <input type="text" name="cname"> <input
				type="hidden" name="switch" value="1"> <input type="submit"
				name="addclass" value="Add Class">
		</form>
		<br> <br>
		<table cellspacing="2" cellpadding="2">
			<tr>
				<th>CLASS ID</th>
				<th>CLASS NAME</th>
			</tr>
			<%
				for (Classes cls : clslist) {
			%>
			<tr>
				<td><%=cls.getClassid()%></td>
				<td><%=cls.getClassname()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br> <br>
		<h3>To Add new a Subject</h3>
		<form action="Adclassname" method="post">
			Enter the Subject Name: <input type="text" name="sname"> <input
				type="hidden" name="switch" value="2"> <input type="submit"
				name="addclass" value="Add Subject">
		</form>
		<table cellspacing="2" cellpadding="2">
			<tr>
				<th>SUBJECT ID</th>
				<th>SUBJECT NAME</th>
			</tr>
			<%
				for (Subjects sub : sublist) {
			%>
			<tr>
				<td><%=sub.getSubjectid()%></td>
				<td><%=sub.getSubjectname()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br> <br>
		<h3>To Add a new Teacher</h3>
		<form action="Adclassname" method="post">
			Enter the Teacher Name: <input type="text" name="tname"> <input
				type="hidden" name="switch" value="3"> <input type="submit"
				name="addclass" value="Add Techer">
		</form>
		<br> <br>
		<table cellspacing="2" cellpadding="2">
			<tr>
				<th>TEACHER ID</th>
				<th>TEACHER NAME</th>
			</tr>
			<%
				for (Teachers teacher : teachlist) {
			%>
			<tr>
				<td><%=teacher.getTeacherId()%></td>
				<td><%=teacher.getTeachername()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<br>
	<br>
	<div align="center">
		<h3>TO Add student and Assign to class</h3>
		<form action="Adclassname" method="post">
			Enter the student Name:<input type="text" name="student">
			select the class: <select name="classid">
				<%
					for (Classes cls : clslist) {
				%><option value="<%=cls.getClassid()%>"><%=(cls.getClassname())%></option>
				<%
					}
				%>
			</select>
			<input type="hidden" name="switch" value="4"> <input
				type="submit" name="studentname" value="addstudent">
		</form>

		<table cellspacing="2" cellpadding="2">
			<tr>
				<th>STUDENT ID</th>
				<th>STUDENT NAME</th>
				<th>CLASS NAME</th>
			</tr>
			<%
				for (Student student : studlist) {
					Classes classes = student.getClasses();
			%>
			<tr>
				<td><%=student.getStudentId()%></td>
				<td><%=student.getStudent_name()%></td>
				<td><%=classes.getClassname()%></td>
			</tr>
			<%
				}
			%>
		</table>



		<h3>Assign subject to class</h3>
		<form action="Adclassname" method="get">
			select the class: <select name="classid2s">
				<%
					for (Classes cls : clslist) {
				%><option value="<%=cls.getClassid()%>"><%=cls.getClassname()%></option>
				<%
					}
				%>
			</select>
			select the subject <select name="subjectid2c">
				<%
					for (Subjects sub : sublist) {
				%><option value="<%=sub.getSubjectid()%>"><%=sub.getSubjectname()%></option>
				<%
					}
				%>

			</select>
			<input type="hidden" name="switch" value="5"> <input
				type="submit" name="subj2class" value="submit">
		</form>


		<h3>Assign subject to Teacher</h3>
		<form action="Adclassname" method="get">
			select the subject <select name="subjectid2techer">
				<%
					for (Subjects sub : sublist) {
				%><option value="<%=sub.getSubjectid()%>"><%=sub.getSubjectname()%></option>
				<%
					}
				%>
			</select> select the Teacher:<select name="teacherid2sub">
				<%
					for (Teachers teacher : teachlist) {
				%><option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeachername()%></option>
				<%
					}
				%>
			</select> <input type="hidden" name="switch" value="6"> <input
				type="submit" name="teach2subj" value="submit">
		</form>
<table cellspacing="2" cellpadding="2">

<tr><th>SUBJECT ID</th><th>SUBJECT NAME</th><th>CLASS NAME</th><th>TEACHER NAME</th></tr>
<%
if(sublist!= null)  // Null check for the object
{
	Iterator<Subjects> iterator = sublist.iterator();
	while(iterator.hasNext()) 
	{
		 Subjects subject = iterator.next();
				Classes class2=subject.getClasses();
				Teachers teach2= subject.getTeacher();
				String getclsname;
				if(class2==null){
					 getclsname = "Not assigned ";
				}else{
					getclsname = class2.getClassname();
					
				}
				String getteachname;
				if(teach2==null){
					getteachname = "Not assigned";
				}else{
					getteachname = teach2.getTeachername();
					
				}
	%>
	<tr><td><%=subject.getSubjectid()%></td>
		<td><%=subject.getSubjectname()%></td>
		<td><%=getclsname%></td>
		<td><%=getteachname%></td>
	</tr>
	<%
	}
}
%>
</table>
		
		<h3>Assign Teacher to class</h3>
		<form action="Adclassname" method="post">

			select the Teacher <select name="teacher2cls">
				<%
					for (Teachers teacher : teachlist) {
				%><option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeachername()%></option>
				<%
					}
				%>
			</select> select the class: <select name="classid2teach">
				<%
					for (Classes cls : clslist) {
				%><option value="<%=cls.getClassid()%>"><%=cls.getClassname()%></option>

				<%
					}
				%>

			</select> <input type="hidden" name="switch" value="7"></input> <input
				type="submit" name="teach2class" value="submit"></input>
		</form>
	</div>
	<h3>TO VIEW REPORT OF EACH CLASSES</h3>
	<form action="Classreport" method="post">
		select the class: <select name="classid8">
			<%
				for (Classes cls : clslist) {
			%><option value="<%=cls.getClassid()%>"><%=cls.getClassname()%></option>
			<%}%>
		</select> <input type="submit" name="studentname" value="submit"></input>
	</form>
	<br>
	<br>
</body>
<h2>DEVLOPED BY : Shereena</h2>
</html>