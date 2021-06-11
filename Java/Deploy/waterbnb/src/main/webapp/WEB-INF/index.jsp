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
  <body>
    <header class="container text-end py-3">
      <c:choose>
        <c:when test="${userId == null}">
          <a href="/guest/signin" class="">Login/Register</a>
        </c:when>
        <c:when test="${userId != null}">
          <a href="/logout" class="">Log Out</a>
        </c:when>
      </c:choose>
    </header>
    <section class="container py-3 text-center">
      <h4>Find places to swim and sleep on water bnb</h4>
      <form
        action="/search"
        method="GET"
        class="col-5 d-inline-block mt-3 text-center"
      >
        <input
          type="text"
          name="location"
          class="form-control"
          placeholder="Location"
          autocomplete="off"
        />
        <input
          type="submit"
          value="Search"
          class="btn btn-outline-primary mt-3"
        />
      </form>
    </section>
  </body>
</html>
