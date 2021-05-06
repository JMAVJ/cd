<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Result</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="col-4 border">
      <h4>Submitted Info</h4>
      <p>Name: <c:out value="${name}" /></p>
      <p>Location: <c:out value="${location}" /></p>
      <p>Favorite Language: <c:out value="${language}" /></p>
      <p>Comment: <c:out value="${comment}" /></p>
      <a href="/">
        <button class="btn btn-primary">Go Back</button>
      </a>
    </div>
  </body>
</html>
