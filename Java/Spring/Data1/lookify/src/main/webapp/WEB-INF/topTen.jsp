<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Top Ten</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <header class="d-flex py-3 justify-content-between container">
      <h4>Top Ten Songs:</h4>
      <a href="/dashboard">
        <h4>Dashboard</h4>
      </a>
    </header>
    <section class="container">
      <div class="border rounded-3 p-3">
        <ul>
          <c:forEach items="${songs}" var="song">
            <li>
              ${song.rating} -
              <a href="/songs/${song.id}"><c:out value="${song.title}" /></a> -
              <c:out value="${song.artist}" />
            </li>
          </c:forEach>
        </ul>
      </div>
    </section>
  </body>
</html>
