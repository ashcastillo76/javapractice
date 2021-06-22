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
	<h1>All Products</h1>

	 
	 <c:forEach items="${products}" var="p">
	 	<p><a href="/products/${p.id}/edit"><c:out value="${p.name}"></c:out></a></p>
	 
	 </c:forEach>
	<a href="categories/new">Create a Category!</a>
</body>
</html>