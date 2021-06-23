<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<thead>
			<tr>
				<td>Question</td>
				<td>ID</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items ="${questions}" var="q">	
				<tr>
					<td><a href="/questions/${q.id }"><c:out value ="${q.textQ}"/></a></td>
					<td><c:out value="${q.id}"/></td>
				</tr>
					
				</c:forEach>
			</tbody>
	</table>
	 
	 
	 <p><a href="questions/new">New Question</a></p>
	 
	
</body>
</html>