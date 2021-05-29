<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body class="bg-dark text-light">
    <section class="container">
      <h1>Questions Dashboard</h1>
      <table class="table table-dark table-striped mt-3">
        <thead>
          <tr>
            <th>Question</th>
            <th>Tags</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${questions}" var="question">
            <tr>
              <td>
                <a href="/questions/${question.id}"
                  ><c:out value="${question.question}"
                /></a>
              </td>
              <td>
                <p>
                  <c:forEach var="tag" items="${question.tags}">
                    <c:out value="${tag.subject}" />
                  </c:forEach>
                </p>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="/questions/new">New Question</a>
    </section>
  </body>
</html>
