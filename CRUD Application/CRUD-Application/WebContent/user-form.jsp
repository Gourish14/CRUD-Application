<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>cozentus </title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color:blue">
<div>
<a href=class="navbar-brand">Cozentus </a>
</div>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav mr-auto">
<li class="nav-item active">
<a class="nav-link" href="<%=request.getContextPath()%>"/list">Home</a>
</li>
<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>"/new">Add Users</a>
</li>
</ul>
</div>
</nav>
</header>
<br>
<div class="row">
<div class="container">
<h3 class="text-center">List of Users</h3>
<hr>
<div class="container text-left">
<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
</div>
<br>
<table class="table table-bordered">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Country</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${listUser}">
<tr>
<td><c:out value="${user.id}" /></td>
<td><c:out value="${user.name}" /></td>
<td><c:out value="${user.email}" /></td>
<td><c:out value="${user.country}" /></td>
</tr>
</c:forEach>
<!-- } -->
</tbody>
</table>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>