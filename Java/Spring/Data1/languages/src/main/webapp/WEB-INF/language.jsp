<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${language.name}" /></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light p-3">
    <h1><c:out value="${language.name}" /></h1>
    <ul>
      <li><c:out value="${language.creator}" /></li>
      <li><c:out value="${language.version}" /></li>
    </ul>
    <a href="/languages/${language.id}/edit">Edit</a>
    <form action="/languages/${language.id}" method="POST" class="d-inline">
      <input type="hidden" name="_method" value="DELETE" />
      <input type="submit" value="Delete" class="btn btn-link" />
    </form>
    <a href="/languages">Go Back</a>
  </body>
</html>
