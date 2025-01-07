<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nagarro Central Library</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" ></script>
	<link rel="stylesheet" href="<c:url value='/css/edit.css' />">

</head>
<body>
 
    <div class="site-wrapper">
        <div class="site-navbar">
            <div>&nbsp;</div>
                <div class="it2">
                  <h4 class="navbar-contents text-center" >Nagarro library</h4>
                 </div>
            <div class="it3">
               <b> Welcome ${lib.name}</b>
               &nbsp;
               <form action="/home" method="post">
           	  	<button class="btn btn-outline-success" type="submit">Home</button>
          </form>
                &nbsp;
                  <form action="/logout" method="post">
                    <input  type="hidden" name="" id="">
                   <button type="submit" class="logoutBtn btn btn-outline-primary">Logout</button> 
                 </form>
                </div>
          </div> 
         
         
    <div class="form-wrapper">
        
        <h1> Edit Book Details</h1>
        <form action="/update" method="post">
            <div class="form-group">
                <label for="code">Book Code</label>
                <input type="text" class="form-control"  id="code" name="bookId" value="${book.bookId }" required readonly>
              </div>
              <div class="form-group">
                <label for="name">Book Name</label> 
                <input type="text" class="form-control"  id="name" name="bookName" value="${book.bookName }" required>
              </div>
              <div class="form-group">
                <label for="author">Author</label> 
                
                <select name="author" id="author" style= "padding-right: 190px;" required>
                	<c:forEach items="${authors}" var="author">
            			<option value="${author.authName}">${author.authName}</option>
        			</c:forEach>
                </select>
                
              </div>
              
              <div class="form-group">
                <label for="email">Date</label> 
                <input type="text" class="form-control"  id="password" name="addedOn" readonly value="${book.addedOn }" required>
              </div>
              <button type="submit" class=" btn btn-outline-primary">Update</button>
              &nbsp;
              <button class="btn btn-outline-danger" type="reset">Cancel</button>
              &nbsp;
          </form>
    </div>
    <div class="site-footer">
        <p class="footer-contents">Nagarro Central Library </p>
    </div>
    </div>
</body>
</html>