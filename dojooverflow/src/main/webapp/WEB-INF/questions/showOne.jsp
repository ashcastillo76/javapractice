<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${question.textQ}</title>
</head>
<body>
<h1><c:out value="${question.textQ}"></c:out></h1>
	
	<ul>
		<c:forEach items="${question.answers}" var="q">
			<li><c:out value="${q.textA}"></c:out></li>
		</c:forEach>
	</ul>
	
	<form:form action="/answers/new" method="post" modelAttribute="answer">
		<form:label path="textA">Add An Answer:</form:label>
		<form:errors path="textA"/>
		<form:textarea path="textA"></form:textarea>
		<form:hidden path="question" value="${question.id}"/>
		<input type="submit" value="Add" />
	</form:form>

</body>
</html>