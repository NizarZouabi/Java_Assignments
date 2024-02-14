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
<title>License</title>
</head>
<body>
  <div>
   <h1>New License</h1>
    <form:form action="/license/create" method="POST" modelAttribute="license">
     Person: <form:select path="person">
      <c:forEach items="${persons}" var="onePerson" >
        <form:option value="${onePerson.id}" path="person">
          <c:out value="${onePerson.firstName}"/>
          <c:out value="${onePerson.lastName}"/>
        </form:option>
      </c:forEach>
     </form:select>
     <form:input path="number" type="hidden" value="${randomnum}"/>
     <form:label path="state" >State: </form:label>
     <form:input type="text" path="state"/>
     <form:errors class="text-danger" path="state"/>
     <form:label path="expirationDate" >Exp date: </form:label>
     <form:input type="date" path="expirationDate"/>
     <form:errors class="text-danger" path="expirationDate"/>
     <button class="btn btn-primary" type="submit">Create</button>
    </form:form>
  </div>
</body>
</html>