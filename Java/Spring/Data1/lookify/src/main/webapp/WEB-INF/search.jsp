<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Search</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <header class="container d-flex justify-content-between py-3">
      <h4>Songs by artist: <c:out value="${artist}" /></h4>
      <form action="/search" method="GET" class="d-flex gap-2 col-4">
        <input type="text" name="artist" id="artist" value="<c:out
          value="${artist}"
        />" class="form-control bg-transparent text-light" autocomplete="off" />
        <input
          type="submit"
          value="Search Artists"
          class="btn btn-outline-primary"
        />
      </form>
      <a href="/dashboard"><h4>Dashboard</h4></a>
    </header>
    <section class="container">
      <table class="table table-dark table-striped">
        <thead>
          <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${songs}" var="song">
            <tr>
              <td><c:out value="${song.title}"/></td>
              <td><c:out value="${song.rating}"/></td>
              <td>
                <form action="/songs/delete/${song.id}" method="POST">
                  <input type="hidden" name="_method" value="DELETE">
                  <input type="submit" class="btn btn-link p-0" value="Delete">
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
  </body>
</html>
