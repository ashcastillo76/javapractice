<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${person.firstName} {person.lastName}"/></title>
</head>
<body>
	<h1><c:out value="${person.firstName} ${person.lastName}"/></h1>
	<p>Name: <c:out value="${person.LastName}"/></p>
	<p>license Number: <c:out value="${person.license.number}"/></p>
	<p>State: <c:out value="${book.numberOfPages}"/></p>
	<p>Expiration Date: <c:out value="${person.license.expirationDate}"/></p>
	
</body>
</html>