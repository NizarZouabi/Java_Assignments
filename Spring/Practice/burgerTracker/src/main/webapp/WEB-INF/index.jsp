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
<body>
   <div class="m-5">
    <div class="container mb-2">
     <h1>Burger Tracker</h1>
    <table class='table table-striped text-center'>
    <thead>
        <tr>
           <th>Burger Name</th>
           <th>Restaurant Name</th>
           <th>Rating(out of 5)</th>
           <th>Action</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${burgers}" var="burger">
         <tr>
           <td><c:out value="${burger.name}"/></td>
           <td><c:out value="${burger.restaurant}"/></td>
           <td><c:out value="${burger.rating}"/></td>
           <td><a href="/burger/${burger.id}">Edit</a></td>
          </tr>
       </c:forEach>
    </tbody>
    </table>
    </div>
    <div class="container mt-2">
     <h2>Add a Burger:</h2>
       <form:form class="d-flex justify-content-center flex-column gap-2" action="/burger" method="POST" modelAttribute="burger">
       <form:label path="name">Burger Name</form:label>
       <form:input type="text" path="name"/>
       <form:errors class="text-danger" path="name"/>
       <form:label path="restaurant">Restaurant Name</form:label>
       <form:input type="text" path="restaurant"/>
       <form:errors class="text-danger" path="restaurant"/>
       <form:select path="rating">
         <form:option value="1">1</form:option>
         <form:option value="2">2</form:option>
         <form:option value="3">3</form:option>
         <form:option value="4">4</form:option>
         <form:option value="5">5</form:option>
       </form:select>
       <form:label path="notes">Notes</form:label>
       <form:textarea cols="6" rows="4" path="notes" ></form:textarea>
       <form:errors class="text-danger" path="notes"/>
       <button class="m-5 btn btn-primary" type='submit' value='submit'>Submit</button>
       </form:form>
    </div>
   </div>
</body>
</html>