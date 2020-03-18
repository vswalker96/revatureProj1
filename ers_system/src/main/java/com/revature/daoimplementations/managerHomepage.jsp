<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.project1.*"%>
    <%@ page import="java.util.*"%>



<html>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<body>

	<h3>Welcome to Manager Homepage!</h3>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
						<span class="sr-only">(current)</span>
					</a></li>

				<li class="nav-item"><a class="nav-link" onclick="viewPending()">View
						Pending</a></li>
				<li class="nav-item"><a class="nav-link" href="VR">View
						Resolved</a></li>
				<li class="nav-item"><a class="nav-link" href="VE">View All
						Employees</a></li>
			</ul>
		</div>

	</nav>
	<div class="container bg-white col-6 m-3 border border-dark rounded">
		<div>

			<body class="container">
				ID: <span id="id"></span><br>
				Amount: <span id="amount"></span><br>
				Description: <span id="description"></span><br>
				Receipt: <span id="receipt"></span><br>
				Created On: <span id="createdOn"></span><br>
				Modified ON: <span id="modifiedOn"></span><br>
				<div>
					<button type="button" class="btn btn-outline-secondary" onclick="viewPending()">View
						Pending</button>
				</div>
		</div>

		<form method="post" action="UP">
			Reimbursement ID: <input type="text" name="requestId" /><br>
			<button type="submit" class="btn btn-outline-secondary" name="requestId" value=2>Approve</button>
		</form>

		<script type="application/javascript">
			function viewPending() {
				alert('inside load');
				var url = "http://localhost:9090/ers_system/api/reimbursement/pending";//use any url that have json data  

				var request;
				if (window.XMLHttpRequest) {
					request = new XMLHttpRequest();//for Chrome, mozilla etc  
				}
				else if (window.ActiveXObject) {
					request = new ActiveXObject("Microsoft.XMLHTTP");//for IE only  
				}
				request.onreadystatechange = function () {
					if (request.readyState == 4) {

						var jsonObj = JSON.parse(request.responseText);//JSON.parse() returns JSON object  

						
						

						/* document.getElementById("id").innerHTML =  jsonObj.id;  
						document.getElementById("amount").innerHTML = jsonObj.amount; 
						document.getElementById("description").innerHTML = jsonObj.description;  
						document.getElementById("receipt").innerHTML = jsonObj.receipt;  
						document.getElementById("createdOn").innerHTML = jsonObj.createdOn;  
						document.getElementById("modifiedOn").innerHTML = jsonObj.modifiedOn;  */

						
					}
				}
				request.open("GET", url, true);
				request.send();
			}

		</script>
</body>

</html>