<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Ninjas </title>
</head>
<body>
	<h1>${dojo.name} Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items ="${dojo.ninjas}" var="n">
				<tr>
					<td><c:out value ="${n.firstName}"/></td>
					<td><c:out value="${n.lastName}"/></td>
					<td><c:out value="${n.age}"/></td>
				</tr>
				</c:forEach>
			</tbody>
	</table>
	
</body>
</html>