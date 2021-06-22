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
	<h1><c:out value="${product.name}"></c:out></h1>
	
	<ul>
		<c:forEach items="${category.name}" var="p">
			<li><c:out value="${c.name}"></c:out></li>
		</c:forEach>
	</ul>
	
	<form action="/category/${product.id}/edit" method="post">
		<label for="category">Add A Category:</label>
		<select name="category_id">
			<option selected disabled >Please Select a Category</option>
			<c:forEach items="${categories}" var="one_category">
				<option value="${one_category.id}">
					<c:out value="${one_category.name}"></c:out>
				</option>
			</c:forEach>
		</select>
	
		<input type="submit" value="Add" />
	</form>
</body>
</html>