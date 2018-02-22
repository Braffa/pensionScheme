<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<%-- jsp directives --%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<title>Charities</title>
</head>

<body>

	<h2>Charities to assign to employee</h2>

<form name="assign" action=/asignCharities method="post" >

	<table border="1" cellpadding="5">
	<tr>
		<th scope="col">Charity ID</th>
		<th scope="col">Charity NameRoom</th>
		<th scope="col">Select</th>
	</tr>

	<c:forEach var="charity" items="${charityForm.charities}" varStatus="status">
	<tr>
		<td>${charity.charityId}</td>
		<td>${charity.charityName}</td>
		<td><INPUT TYPE="checkbox" NAME="check" VALUE="${status.count}">
		<input type="hidden" name="charityId" value="${charity.charityId}"></td>
	</tr>	
		
	</c:forEach>
		
	</table>

<br><br>

<input type="submit" name="assignButton" value="Assign">
<input type="hidden" name="empId" value="${charityForm.empId}">	

</form>
</body>
</html>	
	