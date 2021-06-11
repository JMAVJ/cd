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
    <title>Host Dashboard</title>
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
      <h4>Current Listings</h4>
      <table class="table table-striped">
        <thead>
          <th>Address</th>
          <th>Pool Size</th>
          <th>Cost per night</th>
          <th>Details</th>
        </thead>
        <tbody>
          <c:forEach var="p" items="${user.pools}">
            <tr>
              <td><c:out value="${p.address}" /></td>
              <td><c:out value="${p.size}" /></td>
              <td><c:out value="${p.price}" /></td>
              <td>
                <a href="/host/pool/${p.id}">Edit</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
    <section class="container">
      <form:errors path="pool.*" />
      <form:form
        action="/pools/new"
        method="POST"
        modelAttribute="pool"
        class="col-4"
      >
        <h4>New Listing</h4>
        <form:label path="address" class="form-label">Address</form:label>
        <form:input type="text" path="address" class="form-control" />
        <form:label path="description" class="form-label"
          >Description</form:label
        >
        <form:input type="text" path="description" class="form-control" />
        <form:label path="price" class="form-label">Cost per night</form:label>
        <form:input type="number" path="price" class="form-control" />
        <form:label path="size" class="form-label">Size</form:label>
        <form:select path="size" class="form-control">
          <form:option value="SMALL">Small</form:option>
          <form:option value="MEDIUM">Medium</form:option>
          <form:option value="LARGE">Large</form:option>
        </form:select>
        <input type="submit" value="Add Listing" class="btn btn-primary mt-3">
      </form:form>
    </section>
  </body>
</html>
