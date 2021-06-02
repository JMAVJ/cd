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
    <title>New Ninja</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container">
      <div class="col-6">
        <form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
          <form:label path="dojo" class="form-label">Dojo</form:label>
          <form:select path="dojo" class="form-control">
            <c:forEach items="${dojos}" var="dojo">
              <option value="${dojo.id}"><c:out value="${dojo.name}" /></option>
            </c:forEach>
          </form:select>
          <form:label path="firstName" class="form-label">
            First Name:
          </form:label>
          <form:input type="text" path="firstName" class="form-control" />
          <form:label path="lastName" class="form-label">
            Last Name:
          </form:label>
          <form:input type="text" path="lastName" class="form-control" />
          <form:label path="age" class="form-label">Age:</form:label>
          <form:input type="number" path="age" class="form-control" />
          <input type="submit" value="Create" class="btn btn-primary mt-3">
        </form:form>
      </div>
    </section>
  </body>
</html>
