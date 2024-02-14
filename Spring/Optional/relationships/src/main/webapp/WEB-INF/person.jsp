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
<title>Person</title>
</head>
<body>
  <div>
   <h1>New Person</h1>
    <form:form action="/person/create" method="POST" modelAttribute="person">
     <form:label path="firstName" >First Name: </form:label>
     <form:input type="text" path="firstName"/>
     <form:errors class="text-danger" path="firstName"/>
     <form:label path="lastName" >Last Name: </form:label>
     <form:input type="text" path="lastName"/>
     <form:errors class="text-danger" path="lastName"/>
     <button class="btn btn-primary" type="submit">Create</button>
    </form:form>
  </div>
</body>
</html>