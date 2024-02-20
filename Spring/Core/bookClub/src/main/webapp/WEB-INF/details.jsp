<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
   <div class="container container-sm mt-5 p-2 border">
     <div class="d-flex justify-content-between flex-row">
     <h1 class="fw-bold"><c:out value="${book.title}"/></h1>
     <a href="/books">back to the shelves</a>
     </div>
     
     <c:choose>
      <c:when test="${book.user.id eq userId}">
      <h3><span class="text-warning">You</span> read <span class="text-secondary"><c:out value="${book.title}"/></span> by <span class="text-danger" ><c:out value="${book.author}"/></span>.</h3>
      <h3>Here are <span class="text-warning" >Your</span> thoughts:</h3>
     
      <p class="border lead p-3"><c:out value="${book.thoughts}"/></p>
     </c:when>
      <c:otherwise>
      <h3><span class="text-warning"><c:out value="${book.user.name}"/></span> read <span class="text-secondary"><c:out value="${book.title}"/></span> by <span class="text-danger" ><c:out value="${book.author}"/></span>.</h3>
      <h3>Here are <span class="text-warning" ><c:out value="${book.user.name}"/></span> thoughts:</h3>
     
      <p class="border lead p-3"><c:out value="${book.thoughts}"/></p>
     </c:otherwise>
     </c:choose>
     
     <c:if test="${book.user.id eq userId}">
     <div class="d-flex flex-row gap-3">
      <a href="/book/${book.id}/edit"><button class="btn btn-success">Edit</button></a>
      <form:form action="/book/${book.id}/delete" method="POST"><input type="hidden" name="_method" value="delete"/><button type="submit" class="btn btn-danger">Delete</button></form:form>
     </div>
     </c:if>
     
   </div>
</body>
</html>