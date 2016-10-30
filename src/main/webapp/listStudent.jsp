<%@ page import="java.util.List"%>
<%@ page import="br.com.leandroprado.examplecrud.entidade.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Student</title>

<script type="text/javascript">

function confirmaExclusao (id){
	if (window.confirm('Tem certeza que deseja excluir?')){
		location.href="StudentController.do?acao=excluir&id="+id;
	}
}
</script>

</head>
<body>

<%
	List<Student> lista= (List<Student>)request.getAttribute("listStudent");
%>

	<h2>List Student</h2>
	
	<a href="addStudent.jsp">New</a>
	
	<% if(lista.size() > 0) { %>
	<br><br>
	<table border="1">
	<tr>
		<td>Id</td>
		<td>Last Name</td>
		<td>First Name</td>
		<td>Enrollment Date</td>
		<td>Action</td>
	</tr>
	
	<% for (Student s:lista) {  %>

		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getLastName() %></td>
			<td><%=s.getFirstName() %></td>
			
			<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
			<td><input type="text" name="EnrollmentDate"  value="<%=df.format(s.getEnrollmateDate())%>" /></td>
			<td>
				<a href="javascript:confirmaExclusao(<%=s.getId()%>)">Delete</a> |
				<a href="StudentController.do?acao=alterar&id=<%=s.getId()%>">Edit</a>
			</td>
		</tr>

	<% } %>
	
	</table>
	
	<% } %>
	
</body>
</html>