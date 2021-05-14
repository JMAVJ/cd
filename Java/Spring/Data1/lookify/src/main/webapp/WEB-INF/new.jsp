<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Song</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <header class="container text-end">
      <a href="/"><h4>Dashboard</h4></a>
    </header>
    <section class="container text-center pt-5">
      <div class="col-6 d-inline-block text-start">
        <form:form action="/songs/new" method="POST" modelAttribute="song">
          <form:label path="title" class="form-label">Title</form:label>
          <form:errors path="title" class="text-danger" />
          <form:input
            path="title"
            type="text"
            class="form-control bg-transparent text-light"
          />
          <form:label path="artist" class="form-label">Artist</form:label>
          <form:errors path="artist" class="text-danger" />
          <form:input
            type="text"
            path="artist"
            class="form-control bg-transparent text-light"
          />
          <form:label path="rating" class="form-label"
            >Rating (1-10)</form:label
          >
          <form:errors path="rating" class="text-danger" />
          <form:input
            type="number"
            path="rating"
            min="1"
            max="10"
            value="10"
            class="form-control bg-transparent text-light"
          />
          <input
            type="submit"
            value="Add"
            class="btn btn-outline-primary mt-3"
          />
        </form:form>
      </div>
    </section>
  </body>
</html>
