<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Product to Category</title>
</head>
<body>
   <div class="d-flex justify-content-center flex-column container-sm mt-5">
   <h2>${product.name}</h2>
   
    <a href="/">Home</a>
    <div class="d-flex flex-column">
    <h4 class="mx-5 my-2">Categories:</h4>
     <ul>
     <c:forEach var="categories" items="${product.categories}">
      <li>${categories.name}</li>
     </c:forEach>
     </ul>
    </div>
    
    <h3>Add Category:</h3>
    <form:form class="form-control border" action="/product/${product.id}/add" method="POST" modelAttribute="product">
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="productId" value="${product.id}"/>
      <form:select name="id"  path="id">
        <c:forEach var="category" items="${unjoinedCategories}">
         <form:option value="${category.id}">${category.name}</form:option>
        </c:forEach>
      </form:select>
      <button class="btn btn-primary" type="submit">Add</button>
    </form:form>
   </div>
</body>
</html>