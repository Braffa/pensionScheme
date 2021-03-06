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
					<th>niNumber</th>
					<th>Charities</th>
				</tr>
				<c:forEach items="${lOfEmployees}" var="employee">
					<tr>
						<td>${employee.niNumber}</td>
						<td>
						<c:forEach items="${employee.charities}" var="charity">
							${charity.charityName}
						</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>
