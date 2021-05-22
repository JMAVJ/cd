<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${dojo.name}"/></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <h1><c:out value="${dojo.name}" /> Location Ninjas</h1>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
              <td><c:out value="${ninja.firstName}" /></td>
              <td><c:out value="${ninja.lastName}" /></td>
              <td><c:out value="${ninja.age}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
  </body>
</html>
