<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign In</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <section class="container py-3 d-flex justify-content-between align-center">
      <div class="col-5">
        <h4>Register</h4>
        <form:errors path="user.*" />
        <form:form action="/register" method="POST" modelAttribute="user">
          <form:label path="firstName" class="form-label">First Name</form:label>
          <form:input type="text" path="firstName" class="form-control" />
          <form:label path="lastName" class="form-label">Last Name</form:label>
          <form:input type="text" path="lastName" class="form-control" />
          <form:label path="email" class="form-label">Email</form:label>
          <form:input type="email" path="email" class="form-control" />
          <form:label path="password" class="form-label">Password</form:label>
          <form:input type="password" path="password" class="form-control" />
          <form:label path="passwordConfirmation" class="form-label">Confirm Password</form:label>
          <form:input type="password" path="passwordConfirmation" class="form-control" />
          <form:label path="userType">Account Type</form:label>
          <form:select path="userType" class="form-control">
            <form:option value="HOST">Host</form:option>
            <form:option value="GUEST">Guest</form:option>
          </form:select>
          <input type="submit" value="Register" class="btn btn-primary mt-3">
        </form:form>
      </div>
      <div class="col-5">
        <form action="/login" method="POST">
          <h4>Login</h4>
          <label for="email" class="form-label">Email</label>
          <input type="email" name="email" id="email" class="form-control">
          <label for="password" class="form-label">Password</label>
          <input type="password" name="password" id="password" class="form-control">
          <input type="submit" value="Login" class="btn btn-primary mt-3">
        </form>
      </div>
    </section>
  </body>
</html>
