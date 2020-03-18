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

	<h3 class="text-center">My Details</h3>
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
		User user = (User) session.getAttribute("myEmps");
		if (user != null) {

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
	<h3 class="text-center">Update User</h3>
	<div class="container">
	<form method="post" action="UD" id="yes">
	<div >
		<label>First Name:</label>
		 <input class="form-control" type="text" name="fname" /><br> 
		<label>Last Name: </label>
		<input class=form-control type="text" name="lname" /><br> 
		</div>
		<div>
		<label>Email:</label> 
		<input class="form-control" type="email" name="email" /><br> 
		</div>
		<input class ="btn btn-info" type="submit" value="submit" />
	</form>
</div>
	<a class="btn btn-info" role="button" href="employeeHomepage.jsp">Home</a>
	

</body>
</html>


