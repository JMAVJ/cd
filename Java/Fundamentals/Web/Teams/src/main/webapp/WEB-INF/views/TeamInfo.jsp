<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Info</title>
</head>
<body>
	<h1><c:out value="${team.getName()}"/></h1>
	<a href="/Teams/Players?teamId=${team.getId()}">New Player</a>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${team.getPlayers()}" var="player">
				<tr>
					<td><c:out value="${player.getFirstName()}"/></td>
					<td><c:out value="${player.getLastName()}"/></td>
					<td><c:out value="${player.getAge()}"/></td>
					<td><a href="/Teams/Players?action=delete&playerId=${player.getId()}&teamId=${team.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>