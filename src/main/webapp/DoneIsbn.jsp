<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Isbn No</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="jspfile.css">
</head>
<body>
<div class="container" >
        <h1 class="display-4"style="color:#226B68">Your BookID - <%=session.getAttribute("bookid")%></h1>
        <hr>
        <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Your ISBN No:${isbno.isbn}</h5>
                            <h6 class="card-subtitle mb-2">by ${isbno.author}</h6>
                            <p class="book-info"><strong>Book Title:</strong> ${isbno.title}</p>
                            <p class="book-info"><strong>Language:</strong> ${isbno.language}</p>
                            <p class="book-info"><strong>Pages:</strong>${isbno.pages}</p>
                            <p class="book-price">Rs ${isbno.price}</p>
                        </div>
                    </div>
                </div>
        </div>
        <div class="text-center">
            <a href="/admin" ><button class="btn btn-success">Home</button></a>
        </div>
    </div>
</body>
</html>