<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${e.name}" /></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <header class="container">
      <h1><c:out value="${e.name}" /></h1>
    </header>
    <section class="container d-flex justify-content-between align-center">
      <div class="col-5 d-inline-block">
        <p>
          Host: <c:out value="${e.author.firstName} ${e.author.lastName}" />
        </p>
        <p>Date: <c:out value="${e.date}" /></p>
        <p>Location: <c:out value="${e.location}, ${e.state}" /></p>
        <p>People attending: <c:out value="${e.users.size()}" /></p>
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Name</th>
              <th>Location</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="user" items="${e.users}">
              <tr>
                <td><c:out value="${user.firstName} ${user.lastName}" /></td>
                <td><c:out value="${user.location}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="col-5 d-inline-block">
        <h1>Message Wall</h1>
        <div class="messages">
          <c:forEach var="m" items="${e.messages}">
            <p>
              <c:out
                value="${m.author.firstName} ${m.author.lastName} says: ${m.content}"
              />
            </p>
          </c:forEach>
        </div>
        <form action="/events/message" method="POST">
          <label for="message">Send a message: </label>
          <input type="text" name="message" id="message" class="form-control" />
          <input type="hidden" name="eventId" value="${e.id}" />
          <input type="submit" value="Submit" class="btn btn-primary mt-3" />
        </form>
      </div>
    </section>
  </body>
</html>
