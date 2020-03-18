<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.project1.models.*"%>
<%@ page import ="java.sql.Timestamp" %>
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
<h3 class="text-center">Resolved Requests</h3>
<div class="container col-11">
	<table class="table table-bordered table-info ">
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Description</th>
			<th>Receipt</th>
			<th>Amount</th>
			<th>Created By</th>
			<th>Created On</th> 
			<th>Modified By</th>
			<th>Modified On</th>
		</tr>
<%
		List<Reimburserment> allResolved = (List<Reimburserment>) session.getAttribute("resolved");
		for (Reimburserment reim : allResolved) {

			int id = reim.getId();
			int typeId = reim.getTypeId();
			String description = reim.getDescription();
			String receipt = reim.getReceipt();
			Double amount = reim.getAmount();
			int createdBy = reim.getCreatedBy();
			Timestamp createdOn = reim.getCreatedOn();
			int modifiedBy = reim.getModifiedBy();
			Timestamp modifiedOn = reim.getModifiedOn();
			String cBFname = reim.getCBFname();
			String cBLname = reim.getCBLname();
			
		
			 %>
	            <tr>    
	            	<td><%= id %></td>  
	                <td><%= typeId %></td>
	                <td><%= description %></td>
	                <td><%= receipt %></td>
	                <td><%= amount %></td>
	                <td><%= cBFname %> <%= cBLname %></td>
	                <td><%= createdOn %></td>
	                <td><%= modifiedBy %></td>
	                <td><%= modifiedOn %></td>
	            </tr>
	        <%

		}
	%>
	</table>
		<%
	int roleId = (Integer) session.getAttribute("item2");
	if (roleId == 1) {%>
	<a class="btn btn-info" role="button" href="employeeHomepage.jsp">Home</a>
	<% 
	}else {%>
	<a class="btn btn-info" role="button" href="managerHomepage.jsp">Home</a>
		<% 
	}
	%>
	</div>


</body>
</html>