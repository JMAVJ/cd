<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number Game</title>
</head>
<body>
	<c:choose>
		<c:when test="${!won}">
			<h1>Guess the number between 0 and 100</h1>
			<form method="POST" action="/GreatNumber/Home">
				<input type="number" name="number">
				<input type="submit" value="submit">
			</form>
			<h1><c:out value="${result}"/></h1>
		</c:when>
		<c:when test="${won}">
			<h1>You won!</h1>
			<form method="POST" action="/GreatNumber/ClearSession">
				<input type="submit" value="Play Again">
			</form>
		</c:when>
	</c:choose>
</body>
</html>