<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages Homepage</title>
</head>
<body>
	<h1>All Languages</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
	       <tr>
	           <td> <a href="/languages/${language.id}" ><c:out value="${language.name}"/></a></td>
	           <td><c:out value="${language.creator}"/></td>
	           <td><c:out value="${language.version}"/></td>
	           <td><a href="/languages/${language.id}/edit">Edit</a>|
				<form action="/languages/${language.id}/destroy" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	   
</body>
</html>