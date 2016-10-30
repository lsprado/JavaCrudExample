<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="br.com.leandroprado.examplecrud.entidade.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Student</title>

</head>
<body>

<%
	Student s = (Student)request.getAttribute("student");
%>

<h2>Alter Student</h2>

<form action="StudentController.do" method="post">
	<table border="1">
		<tr>
			<td>Id</td>
			<td><input type="text" name="Id" value="<%=s.getId() %>" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="LastName" value="<%=s.getLastName() %>" /></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="FirstName" value="<%=s.getFirstName() %>" /></td>
		</tr>
		<tr>
			<td>Enrollment Date</td>
			<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
		
			<td><input type="text" name="EnrollmentDate"  value="<%=df.format(s.getEnrollmateDate())%>" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form>
	
</body>
</html>