<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Random String Generator</title>
</head>
<body>
	<h1>
		You have generated
		<c:out value="${stringsGenerated}"/>
		strings
	</h1>
	<p>
		Random String:
		<c:out value="${randomString }" />
	</p>
	<form action="/StringGenerator/Home" method="POST">
		<button>Generate</button>
	</form>
	<p>
		Last string generated on:
		<c:out value="${lastGeneratedAt }" />
	</p>
</body>
</html>