<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>all books</title>
</head>
<body>
  <div class='m-5'>
    <h1>All Books</h1>
    <table class='table table-dark table-striped text-center'>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach items='${books}' var='book'>
         <tr>
           <td><c:out value='${book.id}'/></td>
           <td><a href='/books/${book.id}'><c:out value='${book.title}'/></a></td>
           <td><c:out value='${book.language}'/></td>
           <td><c:out value='${book.numberOfPages}'/></td>
          </tr>
         </c:forEach>
    </tbody>
    </table>
  </div>
</body>
</html>