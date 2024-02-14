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
<title>Add Ninja</title>
</head>
<body>
   <div class="d-flex mt-5 justify-content-center flex-column container-sm border p-2">
     <form:form action="/ninja/new" method="POST" modelAttribute="ninja">
      <form:select path="dojo">
        <c:forEach items="${dojos}" var="dojo">
         <form:option path="dojo" value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
        </c:forEach>
      </form:select>
      <form:label path="firstName">First Name: </form:label>
      <form:input type="text" path="firstName"></form:input>
      <form:errors class="text-danger" path="firstName"/>
      <form:label path="lastName">Last Name: </form:label>
      <form:input type="text" path="lastName"></form:input>
      <form:errors class="text-danger" path="lastName"/>
      <form:label path="age">Age: </form:label>
      <form:input type="number" path="age"></form:input>
      <form:errors class="text-danger" path="age"/>
      <button class="btn btn-primary" type="submit">Create</button>
     </form:form>
     <a href="/">Go back</a>
   </div>
</body>
</html>