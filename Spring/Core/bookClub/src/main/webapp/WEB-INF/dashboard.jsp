<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body class="mt-5">
  <div class="d-flex justify-content-center container flex-column">
    <div class="d-flex justify-content-between">
    <div class="d-flex flex-column">
    <h1>Welcome, <c:out value="${userName}"/> </h1>
    <p>Books from everyone's shelves:</p>
    </div>
    <div class="d-flex flex-column">
    <form:form action="/logout" method="POST"><button type="submit" class="btn btn-secondary">Logout</button></form:form>
    <a href="/book/new">+ Add a book to my shelf!</a>
    </div>
    </div>
    
    <table class="table tabel-striped">
      <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Author Name</th>
          <th>Posted By</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach var="book" items="${books}">
         <tr>
            <td><c:out value="${book.id}"/></td>
            <td><a href="/book/${book.id}/details"><c:out value="${book.title}"/></a></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.user.name}"/></td>
         </tr>
        </c:forEach>
      </tbody>
    </table>
    
  </div>
</body>
</html>