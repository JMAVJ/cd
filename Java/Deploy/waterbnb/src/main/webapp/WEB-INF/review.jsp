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
    <title>Review</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <header class="container text-end">
      <div class="d-inline-block py-3">
        <a href="/" class="d-inline-block">Home</a>
        <a href="/logout" class="d-inline-block">Logout</a>
      </div>
    </header>
    <section class="container">
      <h4>Review of <c:out value="${pool.address}" /></h4>
      <form:form action="/pools/review" method="POST" modelAttribute="review" class="col-6">
        <form:textarea path="message" class="form-control"></form:textarea>
        <form:label path="rating" class="form-label">Rating</form:label>
        <form:select path="rating" class="form-control">
          <form:option value="1">1</form:option>
          <form:option value="2">2</form:option>
          <form:option value="3">3</form:option>
          <form:option value="4">4</form:option>
          <form:option value="5">5</form:option>
        </form:select>
        <input type="hidden" name="poolId" value="${pool.id}">
        <input type="submit" value="Submit Review" class="btn btn-primary mt-3">
      </form:form>
    </section>
  </body>
</html>
