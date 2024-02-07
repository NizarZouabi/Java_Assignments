<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body class="border p-5 m-5">
  <div>
     <div class='fw-bold d-flex flex-row gap-2'><h2>Your Gold: </h2> <h2 class="border border-2 text-warning p-1 pe-3"><c:out value='${gold}'/></div></h2>
    
     <div class='d-flex justify-content-center flex-row gap-5 m-3'>
       <div class='border border-2 text-center p-3'>
       <form action='/farm' method='POST'>
       <h3>Farm</h3>
       <p>(earns 10-20 gold)</p>
       <input type='hidden' name='location' value='farm' />
       <button class='btn btn-sm btn-success'>Find Gold!</button>
       </form>
       </div>
       
       <div class='border border-2 text-center  p-3'>
       <form action='/cave' method='POST'>
       <h3>Cave</h3>
       <p>(earns 5-10 gold)</p>
       <input type='hidden' name='location' value='cave' />
       <button class='btn btn-sm btn-success'>Find Gold!</button>
       </form>
       </div>
       
       <div class='border border-2 text-center  p-3'>
       <form action='/house' method='POST'>
       <h3>House</h3>
       <p>(earns 2-5 gold)</p>
       <input type='hidden' name='location' value='house' />
       <button class='btn btn-sm btn-success'>Find Gold!</button>
       </form>
       </div>
       
       <div class='border border-2 text-center p-3'>
       <form action='/quest' method='POST'>
       <h3>Quest</h3>
       <p>(earns/takes 0-50 gold)</p>
       <input type='hidden' name='location' value='quest' />
       <button class='btn btn-sm btn-success'>Find Gold!</button>
       </form>
       </div>
     </div>
     
     <h2>Activities:</h2>
     <div class='mt-5 container border' style='overflow: auto; height:200px;'>
       <c:forEach items='${activities}' var='activity'>
         <c:choose>
            <c:when test="${activity.contains('earned')}">
              <p class='text-success'><c:out value='${activity}'/></p>
             </c:when>
             <c:otherwise>
              <p class='text-danger fw-bold'><c:out value='${activity}'/></p>
             </c:otherwise>
          </c:choose>
         </c:forEach>
      </div>
     
     <form class='d-flex m-5 justify-content-center' action='/clear' method='POST'>
         <button class='btn btn-danger' type='submit'>Reset</button>
       </form>
  </div>
</body>
</html>