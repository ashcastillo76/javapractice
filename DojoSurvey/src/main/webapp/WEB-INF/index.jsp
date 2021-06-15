<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/submit" method="POST">
	<p>
		<label>Your Name:</label>
		<input type="text" name= "name" placeholder="Enter your name">
	</p>
	<p>
		<label>Dojo Location:</label>
		<select name="location" id="location">
			<option value="San Jose">San Jose</option>
			<option value="Seattle">Seattle</option>
		</select>
	</p>
	<p>
		<label>Favorite Language:</label>
		<select name="language" id="language">
			<option value="Python">Python</option>
			<option value="Java">Java</option>
		</select>
	</p>
	<p>
		<label>Comment (optional):</label>
		<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
	</p>	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>