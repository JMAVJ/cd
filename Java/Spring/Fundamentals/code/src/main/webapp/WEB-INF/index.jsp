<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Code</title>
  </head>
  <body>
    <h1>What is the code?</h1>
    <form action="/check-code" method="POST">
      <c:out value="${error}" />
      <input type="password" name="code" id="code" />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
