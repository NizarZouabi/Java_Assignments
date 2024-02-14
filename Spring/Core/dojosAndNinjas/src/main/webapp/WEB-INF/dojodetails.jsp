<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Dojo</title>
</head>
<body>
    <div class="d-flex mt-5 justify-content-center flex-column container-sm border p-2">
      <h1><c:out value="${dojo.name}"/></h1>
      <table class="table table-striped text-center">
         <thead>
           <tr>
             <th>FirstName</th>
             <th>LastName</th>
             <th>Age</th>
           </tr>
         </thead>
         <tbody>
          <c:forEach items="${dojo.ninjas}" var="ninjas">
           <tr>
             <td><c:out value="${ninjas.firstName}"/></td>
             <td><c:out value="${ninjas.lastName}"/></td>
             <td><c:out value="${ninjas.age}"/></td>
           <tr>
          </c:forEach>
         </tbody>
      </table>
      <a href="/">Go back</a>
    </div>
</body>
</html>