<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<body>
	<h3>Welcome to Employee Homepage</h3>

	<form method="post" action="CR">
		Description: <input type="text" name="description" /><br>
		Receipt: <br> <input type="radio" id="yes" name="receipt"
			value="Yes"> <label for="yes">Yes</label> <input type="radio"
			id="no" name="receipt" value="No"> <label for="no">No</label><br>
		Amount: <input type="number" name="amount" /> <label for="types">Reason:
		</label> <select id="typeId" name="typeId">
			<option value=1>Food</option>
			<option value=2>Travel Expenses</option>
			<option value=3>Certification</option>
			<option value=4>Equipment</option>
			<option value=5>Other</option>
		</select> <input type="submit" value="submit" />
	</form>
	
	<form method="post" action="UD">
		First Name: <input type="text" name="fname" /><br>
		Last Name: <input type="text" name="lname" /><br>
		Email: <input type="text" name="email" /><br>
		
		<input type="submit" value="submit" />
	</form>
	

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home </a></li>
				<li class="nav-item"><a class="nav-link" href="VP">View Pending</a></li>
				<li class="nav-item"><a class="nav-link" href="VR">View Resolved</a></li>
				<li class="nav-item"><a class="nav-link" href="ED">My Details</a></li>
			</ul>
		</div>

	</nav>
</body>
</html>