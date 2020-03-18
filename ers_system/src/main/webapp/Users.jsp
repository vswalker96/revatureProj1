<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.project1.models.*"%>

<!DOCTYPE html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3 class="text-center">Employees</h3>
	<div class="container col-10 ">
	<table class="table table-bordered table-info ">
		<tr>
			<th>User ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Email</th>
		</tr>
<%
		List<User> allUsers = (List<User>) session.getAttribute("myEmps");
		for (User user : allUsers) {

			String firstname = user.getFirstName();
			String lastname = user.getLastName();
			String email = user.getEmail();
			int userId = user.getUserId();
			String username = user.getUsername();
			 %>
	            <tr>    
	            	<td><%= userId %></td>  
	                <td><%= firstname %></td>
	                <td><%= lastname %></td>
	                <td><%= username %></td>
	                <td><%= email %></td>
	            </tr>
	        <%

		}
	%>
	</table>
	</div>
	
	<a class="btn btn-info" role="button" href="managerHomepage.jsp">Home</a>
	


</body>
</html>


