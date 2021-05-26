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
    <title>New Product</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <h1>New Product</h1>
      <form:form action="/products/new" method="POST" modelAttribute="product">
        <form:label path="name" class="form-label">Name:</form:label>
        <form:input type="text" path="name" class="form-control" />
        <form:label path="description" class="form-label">Description:</form:label>
        <form:input type="text" path="description" class="form-control" />
        <form:label path="price" class="form-label">Price:</form:label>
        <form:input path="price" type="number" step=".01" class="form-control" />
        <input type="submit" value="Create" class="btn btn-primary mt-3">
      </form:form>
    </section>
  </body>
</html>
