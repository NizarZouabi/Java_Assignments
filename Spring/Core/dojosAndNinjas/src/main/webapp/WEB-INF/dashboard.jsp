<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>All Dojos</title>
</head>
<body>
   <div class="d-flex mt-5 justify-content-center flex-column container-sm border p-2">
   <div class="d-flex flex-row justify-content-between">
   <h1>All Dojos:</h1>
   <div class=""><a class="btn btn-sm btn-primary me-2" href="/dojo">Add a Dojo</a><a class="btn btn-sm btn-success" href="/ninja">Add a Ninja</a></div>
   </div>
       <ul>
         <c:forEach items="${dojos}" var="dojo">
           <li><a href="/dojo/${dojo.id}/details"><c:out value="${dojo.name}"/></a></li>
          </c:forEach>
       </ul>
   </div>
</body>
</html>