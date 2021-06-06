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
    <title>Edit Event</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <h1><c:out value="${e.name}" /></h1>
      <h4>Edit Event</h4>
      <form:form
        action="/events/edit"
        class="form col-6"
        modelAttribute="editedEvent"
      >
        <form:label path="name">Name:</form:label>
        <form:input
          type="text"
          path="name"
          value="${e.name}"
          class="form-control"
        />
        <form:label path="date" class="form-label">Date</form:label>
        <form:input
          type="date"
          path="date"
          value="${eventDate}"
          class="form-control"
        />
        <form:label path="location" class="form-label">Location:</form:label>
        <form:input
          type="text"
          path="location"
          value="${e.location}"
          class="form-control"
        />
        <form:select path="state" class="form-control mt-2" value="e.state">
          <form:option value="${e.state}" selected="selected"
            >${e.state}</form:option
          >
          <form:option value="FL">FL</form:option>
        </form:select>

        <input type="hidden" name="eventId" value="${e.id}" />
        <input type="submit" value="Edit" class="btn btn-primary mt-3" />
      </form:form>
    </section>
  </body>
</html>
