<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body class="d-flex justify-content-center">
   <div class="m-5" style="width:500px;">
     <div class="d-flex flex-row justify-content-between border">
      <h1 class="text-primary m-2">Expense Details</h1> <a class="m-3" href="/">Go back</a>
     </div>
     <div class="">
       <p class="fw-bold">Expense Name: <c:out value="${expense.name}"/></p>
       <p class="fw-bold">Expense Description: <c:out value="${expense.description}"/></p>
       <p class="fw-bold">Vendor: <c:out value="${expense.vendor}"/></p>
       <p class="fw-bold">Amount Spent: $<c:out value="${expense.amount}"/></p>
     </div>
   </div>
</body>
</html>