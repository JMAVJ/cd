<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${book.title}" /></title>
  </head>
  <body>
    <h1><c:out value="${book.title}" /></h1>
    <p>Author: <c:out value="${book.author}" /></p>
    <p>Number of pages: <c:out value="${book.pages}" /></p>
    <a href="/books/${book.id}/edit">Edit Book</a>
    <form action="/books/${book.id}" method="post">
      <input type="hidden" name="_method" value="delete" />
      <input type="submit" value="Delete" />
    </form>
  </body>
</html>
