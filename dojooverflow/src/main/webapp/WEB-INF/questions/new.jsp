<%@ page isErrorPage="true" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/custom.css" />
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>What is your question?</h1>
	<form action="/questions/new" method="post">
	    <p>
	        <label>Question:</label>
	        <textarea name="textQ" id="textQ" cols="30" rows="10"></textarea>
	    </p>
	    <p>
	    	<label>Tag:</label>
	    	<input type="text" name= "tag" placeholder="Enter a subject for your question"/>
	    </p>
	  
	    	<input type="submit" value="Submit"/>
	</form>    
</body>
</html>