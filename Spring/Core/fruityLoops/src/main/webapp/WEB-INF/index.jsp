<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<title>fruit store</title>
</head>
<body>
<div>
   <div>
   <h2>Fruit Store</h2>
   <table>
   <tbody>
   <tr>
     <th>Name</th>
     <th>Price</th>
   </tr>
   <c:forEach var="fruit" items="${fruitslist}">
   <tr>
     <td><c:out value="${fruit.name}"></c:out></td>
     <td><c:out value="${fruit.price}"></c:out></td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
   </div>
</div>
</body>
</html>