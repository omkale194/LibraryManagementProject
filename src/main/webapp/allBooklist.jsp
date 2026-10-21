<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="jspfile.css">
</head>
<body>
     <div class="container ">
        <h1 class="display-4 page-title">All Book List : ${count }</h1>
        <div class="d-flex justify-content-between align-items-center mb-4">
            <a href="/admin" class="btn btn-home">Home</a>
        </div>
        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
            <c:forEach items="${booklist}" var="b">
                <div class="col">
                    <div class="card h-100 shadow">
                        <div class="card-body">
                            <h5 class="card-title fw-bold">${b.title}</h5>
                            <p class="card-text">
                                <strong>BookID:</strong> ${b.bookid}<br>       
                                <strong>Author:</strong> ${b.author}<br>
                                <strong>Genre:</strong> ${b.genre}<br>
                                <strong>Language:</strong> ${b.language}<br>
                                <strong>Description:</strong> ${b.description}
                            </p>
                        </div>
                        <div class="card-footer">
                            <strong>Price:</strong> Rs ${b.price}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>