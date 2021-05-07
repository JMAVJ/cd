<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ninja Gold</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body class="bg-dark text-light">
    <section class="container">
      <h1 class="aqua">Your Gold: <c:out value="${gold}" /></h1>
    </section>
    <section class="col-8 container text-center p-3">
      <form
        action="/gold"
        method="POST"
        class="col-2 d-inline-block text-center border border-light rounded-3 mx-3 p-2"
      >
        <h1>Farm</h1>
        <p>earns 10-20 gold</p>
        <input type="hidden" name="place" value="farm" />
        <input
          type="submit"
          value="Find Gold!"
          class="btn btn-outline-primary"
        />
      </form>
      <form
        action="/gold"
        method="POST"
        class="col-2 d-inline-block text-center border border-light rounded-3 mx-3 p-2"
      >
        <h1>Cave</h1>
        <p>earns 5-10 gold</p>
        <input type="hidden" name="place" value="cave" />
        <input
          type="submit"
          value="Find Gold!"
          class="btn btn-outline-primary"
        />
      </form>
      <form
        action="/gold"
        method="POST"
        class="col-2 d-inline-block text-center border border-light rounded-3 mx-3 p-2"
      >
        <h1>House</h1>
        <p>earns 2-5 gold</p>
        <input type="hidden" name="place" value="house" />
        <input
          type="submit"
          value="Find Gold!"
          class="btn btn-outline-primary"
        />
      </form>
      <form
        action="/gold"
        method="POST"
        class="col-2 d-inline-block text-center border border-light rounded-3 mx-3 p-2"
      >
        <h1>Casino</h1>
        <p>earns/takes 0-50 gold</p>
        <input type="hidden" name="place" value="casino" />
        <input
          type="submit"
          value="Find Gold!"
          class="btn btn-outline-primary"
        />
      </form>
    </section>
    <section class="col-8 container">
      <h1>Activities</h1>
      <div class="activity overflow-scroll m-auto border rounded p-2">
        <c:forEach items="${activities}" var="activity">
          <p><c:out value="${activity}" /></p>
        </c:forEach>
      </div>
    </section>
  </body>
</html>
