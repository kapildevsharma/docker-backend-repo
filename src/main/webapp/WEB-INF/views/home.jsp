<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
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
	<link rel="stylesheet" href="<c:url value='/css/admin.css' />">

</head>
<body> 

    <div class="site-wrapper">
    <div class="site-navbar">
        <div>&nbsp;</div>
            <div class="it2">
              <h4 class="navbar-contents" >Nagarro Library</h4>
             </div>
        <div class="it3">
            <b>Welcome ${lib.name}</b>
            &nbsp;
              <form action="logout" method="post">
                <input  type="hidden" name="" id="">
               <button type="submit" class="logoutBtn btn btn-outline-primary">Logout</button> 
             </form>
            </div>
      </div> 
    
    <div class="table-wrapper">
        <div class="table-header">
         <div>&nbsp;</div>
            <div class="it2"><h4>Book Listing</h4></div>
            
          <div class="it3">
              
                  <input  type="hidden" name="" id="">
                  <form action="/addBook">
                  <button onclick="" class="addBtn btn btn-primary">Add a Book</button>
                  </form>
               
               
          </div>
        </div> 
        <br> 
        <table>
            <tr>
              <th>Book Code</th>
              <th>Book Name</th>
              <th>Author</th>
              <th>Date added</th>
              <th>Actions</th>
            </tr>
            <c:forEach items="${books }" var="book">
             <tr>
               	<td>${book.bookId }</td>
                <td>${book.bookName }</td>
                <td>${book.author.authName }</td>
                <td>${book.addedOn }</td>
                <td class="lst-colm">
                    <div>
                        <form action="<c:url value='edit/${book.bookId}' />" method="get">
                            <input type="hidden" name="code" value=" code id">
                        <button type="submit" onclick=" " class="btn btn-outline-secondary">Edit</button>
                        </form>
                    </div>
                    
                    &nbsp;
                    <div>
                        <form action="<c:url value='delete/${book.bookId }' /> ">
                        	
                            <input type="hidden" name="code" value="data here..">
                        <button type="submit" onclick="" class="btn btn-outline-danger">delete</button>
                        </form>
                    
                    </div>
                   
                </td>
               
               

            </tr>
       </c:forEach>
            </table>
    </div>
    <div class="site-footer">
        <p class="footer-contents">Nagarro Central Library </p>
    </div>
    </div>
</body>
</html>


