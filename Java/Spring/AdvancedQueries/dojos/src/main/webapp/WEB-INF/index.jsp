<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dojos</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <h1>Dojos</h1>
      <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/page/${index}">${index}</a>
      </c:forEach>
      <table class="table table-striped">
        <thead>
          <tr>
            <td>Dojo</td>
            <td>First Name</td>
            <td>Last Name</td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="n" items="${ninjas.content}">
            <tr>
              <td><c:out value="${n.dojo.name}" /></td>
              <td><c:out value="${n.firstName}" /></td>
              <td><c:out value="${n.lastName}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
  </body>
</html>
