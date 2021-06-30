<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create An Idea</title>
</head>
<body>
	<h1>Create A New Idea:</h1>
	<form:form action="/ideas/new" method="post" modelAttribute="idea">
		<p>
			<form:label path="content">Content:</form:label>
			<form:errors path="content"/>
			<form:input path="content"/>
		</p>
		
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>