<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Submitted Info</h1>
<h3>Name: <c:out value="${name}"></c:out>  </h3>
<h3>Dojo Location: <c:out value="${location}"></c:out>  </h3>
<h3>Favorite Language: <c:out value="${language}"></c:out>  </h3>
<h3>Comments: <c:out value="${comment}"></c:out> </h3>
<button onClick="/">Go Back</button>
</body>
</html>