<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 class="text-center">Submit Request Here</h3>
<div class = "border border-info container">
	<form method="post" action="CR">
	<div class="form-check">
		<label>Receipt</label> <br> 
		<input class="form-check-input " type="radio" id="yes" name="receipt" value="Yes"> 
		<label for="yes">Yes</label><br> 
		<input class ="form-check-input " type="radio" id="no" name="receipt" value="No"> 
		<label for="no">No</label>
		</div>
<div class="form-row">
		<div class="form-group ">
			<label class="form-group-label">Description</label> 
			<input type="text" class="form-control" name="description" />
		</div>
		</div>
		<div class ="form-row">
		<label>Amount</label> 
		<input class ="form-control" type="number" name="amount" /> 
		<label>Reason:</label> 
		<select class="form-control" id="typeId" name="typeId">
			<option value=1>Food</option>
			<option value=2>Travel Expenses</option>
			<option value=3>Certification</option>
			<option value=4>Equipment</option>
			<option value=5>Other</option>
			
		</select> <input class ="btn btn-info"type="submit" value="submit" />
		</div>
	</form>
	</div>
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
</body>
</html>