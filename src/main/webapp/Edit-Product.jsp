<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.projects" %>
<%@ include file="mainLayout.jsp" %>


<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="UTF-8">
<title>Edit Products</title>
<body>
<%
projects p = (projects) request.getAttribute("product");

%>

<div class="container mt-5">
<div class="row justify-content-center">

<div class="col-md-8">

<div class="card shadow-lg p-4 rounded-4">

<h3 class="text-center mb-4 fw-bold">✏️ Edit Product</h3>

<form action="UpdateProduct" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<%= p.getproduct_id() %>">

<div class="mb-3">
<label class="form-label">Product Title</label>
<input type="text" name="title" class="form-control" value="<%= p.getTitle() %>" required>
</div>

<div class="mb-3">
<label class="form-label">Category</label>
<select name="category" class="form-control">
<option <%= p.getCategory().equals("Electronics")?"selected":"" %>>Electronics</option>
<option <%= p.getCategory().equals("Fashion")?"selected":"" %>>Fashion</option>
<option <%= p.getCategory().equals("Home")?"selected":"" %>>Home</option>
<option <%= p.getCategory().equals("Beauty")?"selected":"" %>>Beauty</option>
</select>
</div>

<div class="mb-3">
<label class="form-label">Brand</label>
<input type="text" name="brand" class="form-control" value="<%= p.getBrand() %>">
</div>

<div class="mb-3">
<label class="form-label">Description</label>
<textarea name="description" class="form-control"><%= p.getDescription() %></textarea>
</div>

<div class="row">
<div class="col-md-6 mb-3">
<label class="form-label">Price</label>
<input type="number" name="price" class="form-control" value="<%= p.getPrice() %>">
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Discount Price</label>
<input type="number" name="discountPrice" class="form-control" value="<%= p.getDiscountPrice() %>">
</div>
</div>

<div class="row">
<div class="col-md-6 mb-3">
<label class="form-label">Rating</label>
<input type="number" step="0.1" name="rating" class="form-control" value="<%= p.getRating() %>">
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Stock</label>
<input type="number" name="stock" class="form-control" value="<%= p.getStock() %>">
</div>
</div>

<div class="mb-3">
<label class="form-label">Current Image</label><br>
<img src="<%= request.getContextPath() %>/files/<%= p.getImg() %>" width="120">
</div>

<div class="mb-3">
<label class="form-label">Change Image</label>
<input type="file" name="img" class="form-control">
</div>

<div class="text-center mt-4">
<button class="btn btn-success px-5">Update Product</button>
</div>

</form>

</div>
</div>
</div>
</div>
</body>
</html>