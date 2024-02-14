<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Person & License</title>
</head>
<body>
   <div>
   <div class="d-flex flex-row justify-content-between">
   <h1>Persons List</h1><a href="/person">Add a Person and a License</a>
   </div>
    <table class="table table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>License Number</th>
            <th>State</th>
            <th>Exp Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${persons}" var="person">
            <tr>
                <td><c:out value="${person.firstName}"/></td>
                <td>
                  <c:choose>
                     <c:when test="${not empty person.license}">
                        <c:out value="${person.license.number}"/>
                      </c:when>
                     <c:otherwise>-</c:otherwise>
                   </c:choose>
               </td>
               <td>
                   <c:choose>
                      <c:when test="${not empty person.license}">
                         <c:out value="${person.license.state}"/>
                       </c:when>
                     <c:otherwise>-</c:otherwise>
                   </c:choose>
                </td>
                <td>
                   <c:choose>
                    <c:when test="${not empty person.license}">
                        <c:out value="${person.license.expirationDate}"/>
                   </c:when>
                  <c:otherwise>-</c:otherwise>
                 </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
   </table>
   </div>
</body>
</html>