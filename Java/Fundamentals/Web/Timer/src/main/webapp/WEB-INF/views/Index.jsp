<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timer</title>
</head>
<body>
	<c:choose>
		<c:when test="${running == null}">
			<a href="/Timer/Timer?action=start">Start</a>
		</c:when>
		<c:otherwise>
			<a href="/Timer/Timer?action=stop">Stop</a>
		</c:otherwise>
	</c:choose>
	<a href="/Timer/Timer?action=reset">Reset</a>
	<table>
		<thead>
			<tr>
				<th>Start</th>
				<th>Stop</th>
				<th>Time</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${times}" var="time">
				<tr>
					<td><c:out value="${time.getStart()}"/></td>
					<td><c:out value="${time.getStop()}"/></td>
					<td><c:out value="${time.getTotal()}s"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>