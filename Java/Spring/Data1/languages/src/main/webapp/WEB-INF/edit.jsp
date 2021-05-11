<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Language</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light p-3">
    <section class="col-8">
      <h1><c:out value="${language.name}" /></h1>
      <form action="/languages/${language.id}" method="POST" class="form">
        <label for="name" class="form-label">Name: </label>
        <input
          type="text"
          name="name"
          id="name"
          value="${language.name}"
          class="form-control bg-transparent text-light"
        />
        <label for="name" class="form-label">Creator: </label>
        <input
          type="text"
          name="creator"
          id="creator"
          value="${language.creator}"
          class="form-control bg-transparent text-light"
        />
        <label for="name" class="form-label">Version: </label>
        <input
          type="text"
          name="version"
          id="version"
          value="${language.version}"
          class="form-control bg-transparent text-light"
        />
        <input type="hidden" name="_method" value="PUT" />
        <input
          type="submit"
          value="Edit"
          class="btn btn-outline-primary mt-2"
        />
      </form>
    </section>
  </body>
</html>
