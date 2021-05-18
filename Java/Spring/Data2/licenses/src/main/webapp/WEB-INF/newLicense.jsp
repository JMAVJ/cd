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
      <h1>New License</h1>
      <form action="/licenses/new" method="POST" class="col-6">
        <label path="person" class="form-label">Person:</label>
        <select path="person" name="personId" class="form-select">
          <c:forEach items="${persons}" var="person">
            <option value="${person.id}">
              <c:out value="${person.firstName} ${person.lastName}" />
            </option>
          </c:forEach>
        </select>
        <label path="state" class="form-label">State</label>
        <input path="state" name="state" class="form-control" />
        <label path="expiration" class="form-label">Expiration Date</label>
        <input
          path="expiration"
          name="expiration"
          type="date"
          class="form-control"
        />
        <input
          type="submit"
          class="btn btn-outline-primary mt-3"
          value="Create"
        />
      </form>
    </section>
  </body>
</html>
