<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${song.title}" /></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <header class="container py-3 text-end">
      <a href="/dashboard"><h4>Dashboard</h4></a>
    </header>
    <section class="container">
      <table>
        <tr>
          <td>Title</td>
          <td><c:out value="${song.title}" /></td>
        </tr>
        <tr>
          <td>Artist</td>
          <td><c:out value="${song.artist}" /></td>
        </tr>
        <tr>
          <td>Rating (1-10)</td>
          <td><c:out value="${song.rating}" /></td>
        </tr>
      </table>
      <form action="/songs/delete/${song.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE" />
        <input type="submit" class="btn btn-link p-0" value="Delete" />
      </form>
    </section>
  </body>
</html>
