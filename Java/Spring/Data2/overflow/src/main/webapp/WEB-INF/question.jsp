<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><c:out value="${question.question}" /></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <section class="container">
      <h1><c:out value="${question.question}" /></h1>
      <div class="">
        <h4 class="d-inline-block">Tags:</h4>
        <c:forEach var="tag" items="${question.tags}">
          <div class="d-inline-block p-2 mx-2 border rounded-3 border-primary">
            <c:out value="${tag.subject}" />
          </div>
        </c:forEach>
      </div>
      <section class="d-flex justify-content-between mt-3">
        <div class="col-5 d-inline-block align-top">
          <table class="table table-dark table-striped">
            <thead>
              <tr>
                <th>Answers</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="answer" items="${question.answers}">
                <tr>
                  <td><c:out value="${answer.answer}" /></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col-5 d-inline-block">
          <h4>Add your answer:</h4>
          <form action="/questions/answer" method="POST">
            <c:if test="${error != null}">
              <div class="alert alert-danger">
                <c:out value="${error}" />
              </div>
            </c:if>
            <textarea
              name="answer"
              id="answer"
              cols="30"
              rows="10"
              class="form-control bg-transparent text-light"
            ></textarea>
            <input type="hidden" name="questionId" value="${question.id}" />
            <input
              type="submit"
              value="Submit"
              class="btn btn-outline-primary mt-3"
            />
          </form>
        </div>
      </section>
    </section>
  </body>
</html>
