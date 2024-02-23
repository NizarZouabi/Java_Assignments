<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add a Category</title>
</head>
<body>
    <div class="d-flex justify-content-center flex-column container-sm mt-5">
     <h1 class="text-center">New Product</h1>
       <a href="/">Home</a>
      <form:form class="form-control border" action="/category/create" method="POST" modelAttribute="category">
        <div class="d-flex flex-row">
        <form:label class="border" path="name">Name:</form:label>
        <form:input class="border" type="text" path="name"/>
        <form:errors class="text-danger" path="name"/>
        </div>
        <button class="m-4 btn btn-primary" type="submit">Submit</button>
      </form:form>
      </div>
</body>
</html>