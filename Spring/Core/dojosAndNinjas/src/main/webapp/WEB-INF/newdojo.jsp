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
<title>Add Dojo</title>
</head>
<body>
   <div class="d-flex mt-5 justify-content-center flex-column container-sm border p-2">
     <form:form action="/dojo/new" method="POST" modelAttribute="dojo">
       <form:label path="name">Name: </form:label>
       <form:input path="name" type="text"/>
       <form:errors class="text-danger" path="name"/>
       <button class="btn btn-primary" type="submit">Create</button>
     </form:form>
     <a href="/">Go back</a>
   </div>
</body>
</html>