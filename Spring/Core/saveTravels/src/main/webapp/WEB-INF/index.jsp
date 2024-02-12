<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body class="d-flex justify-content-center">
   <div class="m-5">
    <div class="mb-2">
     <h1 class="text-primary">Save Travels</h1>
    <table class='table table-striped text-center'>
    <thead>
        <tr>
           <th>Expense</th>
           <th>Vendor</th>
           <th>Amount</th>
           <th>Actions</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${expenses}" var="expense">
         <tr>
           <td><a href="/expense/${expense.id}/details"><c:out value="${expense.name}"/></a></td>
           <td><c:out value="${expense.vendor}"/></td>
           <td>$<c:out value="${expense.amount}"/></td>
           <td class="d-flex flex-row gap-2 justify-content-center"><a class="btn btn-sm btn-success" href="/expense/edit/${expense.id}">Edit</a>
           <form action="/expense/delete/${expense.id}" method="POST">
              <input type='hidden' name='_method' value='delete' />
              <button class='btn btn-sm btn-danger' type="submit">Delete</button>
           </form>
           </td>
          </tr>
       </c:forEach>
    </tbody>
    </table>
    </div>
    <div class="container mt-2">
     <h2>Add an expense:</h2>
       <form:form class="d-flex justify-content-center flex-column gap-2 " style="width:500px;" action="/expense" method="POST" modelAttribute="expense">
         <form:label path="name">Expense Name:</form:label>
         <form:input type="text" path="name"/>
         <form:errors class="text-danger" path="name"/>
         <form:label path="vendor">Vendor:</form:label>
         <form:input type="text" path="vendor"/>
         <form:errors class="text-danger" path="vendor"/>
         <form:label path="amount">Amount:</form:label>
         <form:input type="number" min="0" step="0.01" path="amount" />
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