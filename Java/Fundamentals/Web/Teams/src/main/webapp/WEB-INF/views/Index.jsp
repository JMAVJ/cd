<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="/Teams/Teams">New Team</a>
	<table>
		<thead>
			<tr>
				<th>Team</th>
				<th>Players</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${teams}" var="team">
				<tr>
					<td><c:out value="${team.name}"/></td>
					<td><c:out value="${team.getPlayers().size()}"/></td>
					<td><a href="/Teams/Teams?id=${team.getId()}">Details</a></td>
					<td><a href="/Teams/Teams?action=delete&id=${team.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>