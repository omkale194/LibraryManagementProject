<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book Record</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="jspfile.css">
<body style="margin-top:35px">
<div class="container">
<h1 class="display-4"style=color:orange>All Book List</h1>
<hr>
<table class="table table-bordered table-hover">
<tr>
<th>Id
<th>Book ID
<th>DeleteAt
<th>
</tr>
<c:forEach items="${dlist}" var="a" >
<tr>
<td>${a.id }</td>
<td>${a.bookid}</td>
<td>${a.deletedat}</td>
<td style="color:red">Deleted</td>
</tr>
</c:forEach>
</table>
<hr>
<a href="/admin"><button type="button" class="btn btn-outline-success">Home</button></a>
</div>
</body>
</html>