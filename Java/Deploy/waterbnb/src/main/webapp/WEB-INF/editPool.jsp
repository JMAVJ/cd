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
    <title>Edit Pool</title>
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
    <section class="container text-center">
      <form:form
        action="/pools/edit"
        method="POST"
        modelAttribute="updatedPool"
      >
        <div class="col-5 d-inline-block align-top text-start">
          <h4><c:out value="${pool.address}" /></h4>
          <form:textarea
            path="description"
            class="form-control"
          />
          <input type="hidden" name="poolId" value="${pool.id}">
          <input type="submit" value="Save Changes" class="btn btn-primary mt-3">
        </div>
        <div class="col-5 d-inline-block text-start">
          <p>Email: <c:out value="${pool.host.email}" /></p>
          <p>
            Name: <c:out value="${pool.host.firstName} ${pool.host.lastName}" />
          </p>
          <p>Pool Size:
            <form:select path="size" value="${pool.size}">
              <form:option value="SMALL" >Small</form:option>
              <form:option value="MEDIUM" >Medium</form:option>
              <form:option value="LARGE" >Large</form:option>
            </form:select>
          </p>

          <p>Cost: $
            <form:input type="number" path="price" value="${pool.price}"/>
          </p>
        </div>
      </form:form>
    </section>
    <section class="container">
      <div class="d-flex justify-content-between">
        <h4 class="">Reviews</h4>
        <a href="/pools/${pool.id}/review">Leave a review</a>
      </div>
      <c:forEach var="r" items="${pool.reviews}">
        <div class="border-bottom">
          <p><c:out value="${r.user.firstName}" /></p>
          <p><c:out value="${r.rating}/5" /></p>
          <p><c:out value="${r.message}" /></p>
        </div>
      </c:forEach>
    </section>
  </body>
</html>
