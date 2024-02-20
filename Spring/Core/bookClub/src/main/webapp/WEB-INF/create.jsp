<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body class="container container-sm mt-5">
   <div class="d-flex justify-content-center align-items-center flex-column">
     <div class="d-flex justify-content-between flex-row gap-5">
     <h1>Add a Book to Your Shelf!</h1>
     <a href="/books">back to the shelves</a>
     </div>
     
     <form:form class="p-3 form-control d-flex flex-column" action="/book/create" method="POST" modelAttribute="book">
      <form:label path="title">Title: </form:label>
      <form:input type="text" path="title"/>
      <form:errors class="text-danger" path="title"/>
      
      <form:label path="author">Author: </form:label>
      <form:input type="text" path="author"/>
      <form:errors class="text-danger" path="author"/>
      
      <form:label path="thoughts">My thoughts: </form:label>
      <form:textarea rows="6" cols="4" path="thoughts"/>
      <form:errors class="text-danger" path="thoughts"/>
      
      <button class="m-5 btn btn-primary" type="submit">Submit</button>
     </form:form>
     
   </div>
</body>
</html>