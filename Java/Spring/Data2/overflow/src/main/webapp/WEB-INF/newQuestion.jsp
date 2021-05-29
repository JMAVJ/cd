<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Post a Question</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <section class="container">
      <h1>What is your question?</h1>
      <form action="/questions/new" method="POST" class="col-5">
        <c:if test="${errors.size() > 0}">
          <c:forEach var="error" items="${errors}">
            <div class="alert alert-danger">
              <c:out value="${error}" />
            </div>
          </c:forEach>
        </c:if>
        <label for="questions" class="form-label">Question:</label>
        <textarea
          name="question"
          class="form-control bg-transparent text-light"
          id="question"
          cols="30"
          rows="10"
        ></textarea>
        <label for="tags" class="form-label">Tags:</label>
        <input
          type="text"
          name="tags"
          id="tags"
          class="form-control bg-transparent text-light"
        />
        <input
          type="submit"
          value="Submit"
          class="btn btn-outline-primary mt-3"
        />
      </form>
    </section>
  </body>
</html>
