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
	<h1>Add Player</h1>
	<form action="/Teams/Players" method="POST">
		<label for="firstName">First Name: </label> 
		<input type="text" name="firstName" id="firstName" /> 
		<label for="lastName">Last Name: </label> 
		<input type="text" name="lastName" id="lastName" /> 
		<label for="age">Age: </label> 
		<input type="number" name="age" id="age" />
		<input type="hidden" name="teamId" value="${teamId}" /> 
		<input type="submit" value="Add" />
	</form>
</body>
</html>