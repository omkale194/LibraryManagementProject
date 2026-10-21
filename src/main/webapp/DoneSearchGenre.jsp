<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search BY Genre </title>
<link rel="stylesheet" href="jspfile.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body style="margin-top: 35px;"style="color: rgb(247, 211, 167);">
<div class="container" >
        <h1 class="display-4"style="color:#226B68">Search By Genre - <%=session.getAttribute("genre")%></h1>
        <hr>
        <div class="row">
            <c:forEach items="${glist}" var="gen">
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${gen.title}</h5>
                            <h6 class="card-subtitle mb-2">by ${gen.author}</h6>
                            <p class="book-info"><strong>Language:</strong> ${gen.language}</p>
                            <p class="book-info"><strong>Description:</strong>${gen.description}</p>
                            <p class="book-price">Rs ${gen.price}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="text-center">
            <a href="/admin" ><button class="btn btn-success">Home</button></a>
        </div>
    </div>
</body>
</html>