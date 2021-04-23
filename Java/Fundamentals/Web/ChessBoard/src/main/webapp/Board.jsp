<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chess Board</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		int rows = Integer.parseInt(request.getParameter("rows"));
		int cols = Integer.parseInt(request.getParameter("cols"));
	%>
	<h1><%=rows %> x <%=cols %> board</h1>
	<% for (int i=1; i<=rows; i++){ %>
		<% if (i % 2 == 0) { %>
			<div class="row">
				<% for(int j=1; j<=cols; j++){ %>
							<div class="<%= j % 2 == 0 ? "black" : "white" %> square"></div>
				<%}%>
			</div>
		<% } else { %>
			<div class="row">
				<% for(int j=1; j<=cols; j++){ %>
							<div class="<%= j % 2 == 0 ? "white" : "black" %> square"></div>
				<%}%>
			</div>
		<%} %>
	<% } %>
</body>
</html>