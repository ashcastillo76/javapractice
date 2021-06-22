<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
		<h1><c:out value="${category.name}"></c:out></h1>
	
	<ul>
		<c:forEach items="${product.name}" var="p">
			<li><c:out value="${p.name}"></c:out></li>
		</c:forEach>
	</ul>
	
	<form action="/colors/${category.id}/edit" method="post">
		<label for="product">Add A Product:</label>
		<select name="product_id">
			<option selected disabled >Please Select a Product</option>
			<c:forEach items="${products}" var="one_product">
				<option value="${one_product.id}">
					<c:out value="${one_product.name}"></c:out>
				</option>
			</c:forEach>
		</select>
	
		<input type="submit" value="Add" />
	</form>
</body>
</html>