<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Languages</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light p-3">
    <section class="col-8">
      <table class="table table-dark table-striped">
        <thead>
          <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${languages}" var="language">
            <tr>
              <td><a href="/languages/${language.id}"><c:out value="${language.name}" /></a></td>
              <td><c:out value="${language.creator}" /></td>
              <td><c:out value="${language.version}" /></td>
              <td>
                <a href="/languages/${language.id}/edit">Edit</a>
                <form action="/languages/${language.id}" method="POST" class="d-inline">
                  <input type="hidden" name="_method" value="DELETE">
                  <input type="submit" value="Delete" class="btn btn-link">
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
    <section class="col-8 pt-3">
      <form action="/languages" method="POST" class="form col-6">
        <label for="name" class="form-label">Name: </label>
        <input
          type="text"
          name="name"
          id="name"
          class="form-control bg-transparent text-light"
        />
        <label for="name" class="form-label">Creator: </label>
        <input
          type="text"
          name="creator"
          id="creator"
          class="form-control bg-transparent text-light"
        />
        <label for="name" class="form-label">Version: </label>
        <input
          type="text"
          name="version"
          id="version"
          class="form-control bg-transparent text-light"
        />
        <input type="submit" value="Add" class="btn btn-outline-primary" />
      </form>
    </section>
  </body>
</html>
