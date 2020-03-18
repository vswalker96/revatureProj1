<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<body>

	<h3>Welcome to Manager Homepage!</h3>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="VP">View
						Pending</a></li>
				<li class="nav-item"><a class="nav-link" href="VR">View
						Resolved</a></li>
				<li class="nav-item"><a class="nav-link" href="VE">View All
						Employees</a></li>
			</ul>
		</div>

	</nav>
	
	<form method="post" action="UP">
	Reimbursement ID: <input type="text" name="requestId" /><br>
	<label for="statuses">Status: </label>
  <button type="submit" class="btn btn-outline-secondary" name ="requestId" value = 2>Approve</button>
		</form>


</body>

</html>