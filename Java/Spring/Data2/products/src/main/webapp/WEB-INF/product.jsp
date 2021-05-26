<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${product.name}" /></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <h1><c:out value="${product.name}" /></h1>
      <div class="col-5">
        <h4>Categories:</h4>
        <ul>
          <c:forEach items="${product.categories}" var="category">
            <li><c:out value="${category.name}" /></li>
          </c:forEach>
        </ul>
      </div>
      <div class="col-5">
        <form action="/products/add-category" method="POST">
          <select name="category_id" id="category" class="form-control">
            <c:forEach items="${categories}" var="category">
              <option value="${category.id}">
                <c:out value="${category.name}" />
              </option>
            </c:forEach>
          </select>
          <input type="hidden" name="product_id" value="${product.id}" />
          <input type="hidden" name="_method" value="PUT" />
          <input type="submit" value="Add" class="btn btn-primary mt-3" />
        </form>
      </div>
    </section>
  </body>
</html>
