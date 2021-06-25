<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Categories</h1>


	<c:forEach items="${categories}" var="c">
		<p>
			<a href="/categories/${c.id}"><c:out value="${c.name}"></c:out></a>
		</p>

		<form action="/categories/${c.id}/destroy" method="POST">
			<input type="hidden" name="_method" value="delete"> 
			<input type="submit" value="Delete">
		</form>

	</c:forEach>
	<a href="products/new">Create a Product!</a>
	<a href="categories/new">Create a Category!</a>
</body>
</html>