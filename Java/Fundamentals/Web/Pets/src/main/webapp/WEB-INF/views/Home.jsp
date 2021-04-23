<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add a pet</title>
</head>
<body>
	<form action="/Pets/Dogs" method="POST">
		<h1>Add a dog</h1>
		<label for="name">Name:</label>
		<input type="text" name="name">
		<label for="breed">Breed:</label>
		<input type="text" name="breed">
		<label for="weight">Weight (lb):</label>
		<input type="number" name="weight">
		<input type="submit" value="add">
	</form>
	<form action="/Pets/Cats" method="POST">
		<h1>Add a cat</h1>
		<label for="name">Name:</label>
		<input type="text" name="name">
		<label for="breed">Breed:</label>
		<input type="text" name="breed">
		<label for="weight">Weight (lb):</label>
		<input type="number" name="weight">
		<input type="submit" value="add">		
	</form>
</body>
</html>