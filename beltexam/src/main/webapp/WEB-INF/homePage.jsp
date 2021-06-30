<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome,
		<c:out value="${user.name}" />
	</h1>
	<h1>Ideas</h1>
	<table>
		<thead>
			<tr>
				<td>Idea</td>
				<td>Created By</td>
				
			</tr>
			</thead>
			<tbody>
				<c:forEach items ="${ideas}" var="i">
				<tr>
					<td><c:out value ="${i.content}"/></td>
					<td><c:out value="${idea.user}"/></td>
				</tr>
				</c:forEach>
			</tbody>
	</table>
	<a href="/ideas/new">Create An Idea!</a> |
	<a href="/logout">Logout</a>
</body>
</html>