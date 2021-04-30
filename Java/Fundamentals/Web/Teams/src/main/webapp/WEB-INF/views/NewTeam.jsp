<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Team</title>
</head>
<body>
	<h1>Create a new team</h1>
	<form action="/Teams/Teams" method="POST">
		<label for="teamName">Team Name:</label>
		<input type="text" name="teamName">
		<input type="submit" value="Submit">
	</form>
</body>
</html>