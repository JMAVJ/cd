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
    <title>Add a Person</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="col-8">
      <h1>New Person</h1>
      <form:form action="/persons/new" method="POST" class="col-6" modelAttribute="person">
        <form:label path="firstName" class="form-label">First Name</form:label>
        <form:errors path="firstName" class="text-danger" />
        <form:input type="text" path="firstName" class="form-control" />
        <form:label path="lastName" class="form-label">Last Name</form:label>
        <form:errors path="lastName" class="text-danger" />
        <form:input type="text" path="lastName" class="form-control" />
        <input type="submit" class="btn btn-outline-primary mt-3" value="Create">
      </form:form>
    </section>
  </body>
</html>
