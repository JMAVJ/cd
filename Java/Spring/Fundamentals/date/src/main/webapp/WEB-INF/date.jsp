<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Date</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <h1 class="blue title">
      <c:out value="${date}" />
    </h1>
    <script src="date.js"></script>
  </body>
</html>
