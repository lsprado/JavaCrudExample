<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Student here</title>
</head>
<body>
<h2>Create Student</h2>
<form action="StudentController.do" method="post">
	<table border="1">
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="LastName" /></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="FirstName" /></td>
		</tr>
		<tr>
			<td>Enrollment Date</td>
			<td><input type="text" name="EnrollmentDate" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form>
</body>
</html>