<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
  <div class="mt-5 container">
   <h1 class="text-center">Home Page</h1>
   
   <div class="m-3 d-flex flex-column">
    <a href="/product/new">New Product</a>
    <a href="/category/new">New Category</a>
   </div>
   
   <div class="m-3 d-flex flex-row justify-content-center">
   
    <div class="d-flex flex-column border border-black">
     <h4 class="border-bottom border-black px-5 py-2">Products</h4>
      <ul>
      <c:forEach var="product" items="${products}">
       <li><a href="/product/${product.id}">${product.name}</a></li>
      </c:forEach>
      </ul>
    </div>
    
    <div class="d-flex flex-column border border-black">
    <h4 class="border-bottom border-black px-5 py-2">Categories</h4>
     <ul>
     <c:forEach var="category" items="${categories}">
      <li><a href="/category/${category.id}">${category.name}</a></li>
     </c:forEach>
     </ul>
    </div>
     
   </div>
  </div>
</body>
</html>