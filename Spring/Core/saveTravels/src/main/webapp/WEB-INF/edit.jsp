<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Edit Expense ${id}</title>
</head>
<body class="d-flex justify-content-center m-5">
   <div>
     <div class="container mt-2">
     <div class="d-flex flex-row justify-content-between">
     <h2 class='text-success'>Edit Expense: <c:out value="${expense.name}"/></h2> <a href="/">Go back</a>
     </div>
       <form:form class="d-flex justify-content-center flex-column gap-2" style="width:500px;" action="/expense/update/${expense.id}" method="POST" modelAttribute="expense">
         <input type="hidden" name="_method" value="patch">
         <form:label path="name">Expense Name:</form:label>
         <form:input type="text" path="name"/>
         <form:errors class="text-danger" path="name"/>
         <form:label path="vendor">Vendor:</form:label>
         <form:input type="text" path="vendor"/>
         <form:errors class="text-danger" path="vendor"/>
         <form:label path="amount">Amount:</form:label>
         <form:input type="number" min="0" step="0.01" path="amount"/>
         <form:errors class="text-danger" path="amount"/>
         <form:label path="description">Description:</form:label>
         <form:textarea cols="6" rows="4" path="description"></form:textarea>
         <form:errors class="text-danger" path="description"/>
        <button class="m-5 btn btn-primary" type='submit' value='submit'>Submit</button>
       </form:form>
     </div>
   </div>
</body>
</html>