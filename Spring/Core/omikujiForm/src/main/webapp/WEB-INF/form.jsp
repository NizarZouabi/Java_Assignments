<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>omikuji form</title>
</head>
<body>
   <div class='m-3 p-3 bg-light d-flex justify-content-center align-items-center flex-column'>
     <h2>Send an Omikuji!</h2>
     <form class='container p-3 form-control bg-white m-3 p-2 d-flex flex-column shadow' style='width: 500px;' action='/omikuji/submit' method='POST'>
      <label>Pick any number from 5 to 25:</label>
      <input class='m-1' style='width:60px;' type='number' name='num' min='5' max='25'>
      <label>Enter the name of any city:</label>
      <input class='m-1' style='width:250px;' type='text' name='city'>
      <label>Enter the name of any real person:</label>
      <input class='m-1' style='width:250px;' type='text' name='person'>
      <label>Enter professional endeavor or hobby:</label>
      <input class='m-1' style='width:250px;' type='text' name='profession'>
      <label>Enter any type of living thing:</label>
      <input class='m-1' style='width:250px;' type='text' name='creature'>
      <label>Say something nice to someone:</label>
      <textarea class='m-1' cols='2' rows='4' name='txt'></textarea>
      <p>Send and show a friend</p>
      <button class='m-5 btn btn-primary' type='submit' value='omikuji'>Send</button>
     </form>
   </div>
</body>
</html>