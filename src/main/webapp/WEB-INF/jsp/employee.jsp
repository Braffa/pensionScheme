<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<div class="starter-template">
			<table border=1 >
				<tr>
					<th>first Name</th>
					<th>Last name</th>
					<th>NI Number</th>
					<th>Date Of Birth</th>
					<th>Employment Start Date</th>
					<th>salary</th>
					<th>Employee Contribution</th>
					<th>Employer Contribution</th>
					<th>Charities</th>
				</tr>
				<c:forEach items="${employeeForm.getEmployees()}" var="employee">
					<tr> 
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.niNumber}</td>
						<td>${employee.dateOfBirth}</td>
						<td>${employee.employmentStartDate}</td>
						<td>${employee.salary}</td>
						<td>${employee.employeeContribution}</td>
						<td>${employee.employerContribution}</td>
						<td>
						<form name="addCharity" action="/charity" method="get">
							<table>
								<c:forEach items="${employee.charities}" var="charity">
								<tr><td>${charity}</td></tr>
								</c:forEach>
								<tr>
								<td>
								<input type="Submit" value="Add Charity">
								<input type="hidden" name="empId" value="${employee.niNumber}">
								</td></tr>
							</table>
						</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
