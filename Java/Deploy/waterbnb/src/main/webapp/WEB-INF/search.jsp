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
    <header class="container text-end">
      <div class="d-inline-block py-3">
        <a href="/" class="d-inline-block">Home</a>
        <c:if test="${userId != null}">
          <a href="/logout" class="d-inline-block">Logout</a>
        </c:if>
      </div>
    </header>
    <section class="container">
      <h4>Find your pool!</h4>
      <form action="/search" method="GET" class="col-8">
        <div class="form-group row">
          <div class="col-10">
            <input
              type="text"
              name="location"
              placeholder="new search"
              class="form-control"
            />
          </div>
          <input type="submit" value="Search" class="btn btn-primary col-2" />
        </div>
      </form>
      <table class="table table-row">
        <thead>
          <tr>
            <th>Address</th>
            <th>Pool Size</th>
            <th>Cost per night</th>
            <th>Details</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="p" items="${pools}">
            <tr>
              <td><c:out value="${p.address}" /></td>
              <td><c:out value="${p.size}" /></td>
              <td><c:out value="${p.price}" /></td>
              <td><a href="/pools/${p.id}">See more</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
  </body>
</html>
