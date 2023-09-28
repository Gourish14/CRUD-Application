<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>cozentus</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
<div>
<a href= class="navbar-brand"> Cozentus</a>
</div>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav mr-auto">
<li class="nav-item active">
<a class="nav-link" href="<%=request.getContextPath()%>"/new">Home</a>
</li>
<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>"/list">Add Users</a>
</li>
</ul>
</div>
</nav>