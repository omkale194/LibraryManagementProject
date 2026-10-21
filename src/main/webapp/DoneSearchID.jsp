<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="jspfile.css">
</head>
<body>
<div class="container">
        <h1 class="display-4 page-title">Your Book</h1>
        
        <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-lg">
                <div class="card-body">
                    <!-- Book Image Placeholder -->
                    <img src="https://via.placeholder.com/150" class="card-img-top mb-4" alt="" style="max-height: 300px; object-fit: cover;">
                    
                    <h3 class="card-title fw-bold">${id.title}</h3>
                    <p class="card-text">
                        <strong>Book ID:</strong> ${id.bookid} <br>
                        <strong>ISBN:</strong> ${id.isbn} <br>
                        <strong>Author:</strong> ${id.author} <br>
                        <strong>Publisher:</strong> ${id.publisher} <br>
                        <strong>Publication Year:</strong> ${id.publicationyear} <br>
                        <strong>Genre:</strong> ${id.genre} <br>
                        <strong>Language:</strong> ${id.language} <br>
                        <strong>Description:</strong> ${id.description}
                    </p>

                    <div class="d-flex justify-content-between align-items-center mt-4">
                        <span class="fw-bold fs-4">Price: Rs ${id.price}</span>
                        
                        <!-- Buttons for interactive actions -->
                        <div>
                            <a href="#" class="btn btn-outline-success">Buy Now</a>
                            <a href="#" class="btn btn-success">Add to Wishlist</a>
                        </div>
                    </div>
                </div>

                <div class="card-footer text-muted text-center">
                    <small>Pages: ${id.pages} | Language: ${id.language}</small>
                </div>
            </div>
            <div class="d-flex justify-content-between align-items-center mb-4">
            <a href="/admin" class="btn btn-home">Home</a>
        </div>
        </div>
    </div>
</div>
</div>
</body>
</html>