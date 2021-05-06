<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Survey</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <form action="/result" method="POST" class="col-4">
      <label for="name">Your Name:</label>
      <input type="text" class="form-control" name="name" id="" />
      <label for="location">Dojo Location</label>
      <select name="location" class="form-control" id="">
        <option value="" disabled selected>Select a location</option>
        <option value="San Jose">San Jose</option>
      </select>
      <label for="language">Favorite Language</label>
      <select name="language" class="form-control" id="">
        <option value="" disabled selected>Select a language</option>
        <option value="Python">Python</option>
        <option value="JavaScript">JavaScript</option>
        <option value="Java">Java</option>
        <option value="c++">c++</option>
      </select>
      <label for="comment">Comment (optional)</label>
      <textarea
        name="comment"
        id=""
        class="form-control"
        cols="30"
        rows="10"
      ></textarea>
      <input type="submit" value="submit" class="btn btn-primary" />
    </form>
  </body>
</html>
