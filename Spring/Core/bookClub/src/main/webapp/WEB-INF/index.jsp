<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body class="mt-5">
  
  <div class="text-center d-flex flex-column justify-content-center">
  <h1 class="text-warning fw-bold">Book Club</h1>
    <p>A place for friends to share thoughts on books.</p>
  </div>
  
  <div class="mt-5 d-flex gap-2 container container-sm" style="width:800px;">
    
    <div class="container container-sm">
    <form:form class="form-control shadow d-flex justify-content-center flex-column p-3" action="/register" method="POST" modelAttribute="newUser">
     <form:label path="name">Name: </form:label>
     <form:input path="name" type="text"/>
     <form:errors path="name" class="text-danger"/>
     <form:label path="email">Email: </form:label>
     <form:input path="email" type="email"/>
     <form:errors path="email" class="text-danger"/>
     <form:label path="password">Password: </form:label>
     <form:input path="password" type="password"/>
     <form:errors path="password" class="text-danger"/>
     <form:label path="confirmPass">Confirm Password: </form:label>
     <form:input path="confirmPass" type="password"/>
     <form:errors path="confirmPass" class="text-danger"/>
     <button class="btn btn-primary m-5" type="submit">Register</button>
    </form:form>
    </div>
    
    <div class="container container-sm">
    <form:form class="form-control shadow d-flex justify-content-center flex-column p-3" action="/login" method="POST" modelAttribute="newLogin">
     <form:label path="email">Email: </form:label>
     <form:input type="email" path="email"/>
     <form:errors class="text-danger" path="email"/>
     <form:label path="password">Password: </form:label>
     <form:input type="password" path="password" />
     <form:errors class="text-danger" path="password"/>
    <button class="btn btn-primary m-5" type="submit">Login</button>
    </form:form>
    </div>
    
  </div>
</body>
</html>