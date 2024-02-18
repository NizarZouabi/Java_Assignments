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
<title>Home Page</title>
</head>
<body>
  <div class="mt-5 container container-sm">
    <h1>Welcome <c:out value="${userName}"/>!</h1>
    <form:form action="/logout" method="POST"><button class="btn btn-secondary">Logout</button></form:form>
  </div>
</body>
</html>