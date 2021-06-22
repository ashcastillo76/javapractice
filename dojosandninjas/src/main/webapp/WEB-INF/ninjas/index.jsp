<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
</head>
<body>
	<h1>All Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Dojo Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${ninjas}" var="ninja">
			<tr>
				<td>
					<c:out value="${ninja.firstName}"/>
				</td>
				<td>
					<c:out value="${ninja.lastName}"/>
				</td>
				<td>
					<c:out value="${ninja.age}"/>
				</td>
				<td>
					<c:out value="${ninja.dojo.name}"/>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>