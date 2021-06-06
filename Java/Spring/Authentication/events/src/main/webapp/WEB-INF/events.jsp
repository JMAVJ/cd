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
    <title>Events</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <header class="container d-flex justify-content-between align-items-center">
      <h1>Welcome, <c:out value="${user.firstName}" /></h1>
      <a href="/logout">
        <h4>Logout</h4>
      </a>
    </header>
    <section class="container">
      <p>Here are some of the events in your state</p>
      <table class="table table-striped mb-5">
        <thead>
          <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Action/Status</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="e" items="${stateEvents}">
            <tr>
              <td><a href="/events/${e.id}"><c:out value="${e.name}" /></a></td>
              <td><c:out value="${e.date}" /></td>
              <td><c:out value="${e.location}" /></td>
              <td><c:out value="${e.author.firstName} ${e.author.lastName}" /></td>
              <td>
                <c:if test="${e.author == user}">
                  <a href="/events/edit/${e.id}">Edit</a>
                  <a href="">Delete</a>
                </c:if>
                <c:if test="${e.joined}">
                  <span>Joined</span>
                  <form action="/events/cancel" method="POST" class="d-inline-block">
                    <input type="hidden" name="eventId" value="${e.id}">
                    <input type="submit" value="Cancel" class="btn btn-link">
                  </form>
                </c:if>
                <c:if test="${e.author != user && !e.joined}">
                  <form action="/events/join" method="POST" class="d-inline-block">
                    <input type="hidden" name="eventId" value="${e.id}">
                    <input type="submit" value="Join" class="btn btn-link">
                  </form>
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <p>Here are some of the events in other states</p>
      <table class="table table-striped mb-3">
        <thead>
          <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>State</th>
            <th>Host</th>
            <th>Action/Status</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="e" items="${eventsInOtherStates}">
            <tr>
              <td><a href="/events/${e.id}"><c:out value="${e.name}" /></a></td>
              <td><c:out value="${e.date}" /></td>
              <td><c:out value="${e.location}" /></td>
              <td><c:out value="${e.state}" /></td>
              <td><c:out value="${e.author.firstName} ${e.author.lastName}" /></td>
              <td>
                <c:if test="${e.author == user}">
                  <a href="/events/edit/${e.id}">Edit</a>
                  <a href="">Delete</a>
                </c:if>
                <c:if test="${e.joined}">
                  <span>Joined</span>
                  <form action="/events/cancel" method="POST" class="d-inline-block">
                    <input type="hidden" name="eventId" value="${e.id}">
                    <input type="submit" value="Cancel" class="btn btn-link">
                  </form>
                </c:if>
                <c:if test="${e.author != user && !e.joined}">
                  <form action="/events/join" method="POST" class="d-inline-block">
                    <input type="hidden" name="eventId" value="${e.id}">
                    <input type="submit" value="Join" class="btn btn-link">
                  </form>
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>
    <section class="container">
      <h4>Create an Event</h4>
      <form:errors path="event.*" />
      <form:form
        action="/events/new"
        method="POST"
        modelAttribute="event"
        class="col-5"
      >
        <form:label path="name" class="form-label">Name</form:label>
        <form:input type="text" path="name" class="form-control" />
        <form:label path="date">Date</form:label>
        <form:input type="date" path="date" class="form-control" />
        <form:label path="location">Location</form:label>
        <form:input type="text" path="location" class="form-control" />
        <form:select path="state" class="form-control mt-2">
          <form:option value="CA">CA</form:option>
          <form:option value="FL">FL</form:option>
        </form:select>
        <input type="submit" value="Create" class="btn btn-primary mt-3">
      </form:form>
    </section>
  </body>
</html>
