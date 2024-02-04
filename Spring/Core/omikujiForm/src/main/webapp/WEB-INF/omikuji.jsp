<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>omikuji</title>
</head>
<body>
   <div class='m-5 bg-light d-flex justify-content-center align-items-center flex-column'>
     <h2>Here's Your Omikuji!</h2>
     <div class='m-3 p-3 text-center border border-black bg-info' style='width:300px;'>
     <p>In <span style='color: red;'><c:out value='${num}' /></span> years, you will
     live in <span style='color: red;'><c:out value='${city}' /></span> with <span style='color: red;'><c:out value='${person}' /></span> as your
     roommate, <span style='color: red;'><c:out value='${profession}' /></span> for a living.
     The next time you see a <span style='color: red;'><c:out value='${creature}' /></span>, you will
     have good luck.
     Also, <span style='color: red;'><c:out value='${txt}' /></span>.</p>
     </div>
     <a href='/omikuji'>Go Back</a>
   </div>
</body>
</html>