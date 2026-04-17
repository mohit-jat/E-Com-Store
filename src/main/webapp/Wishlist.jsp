<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.projects" %>
<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Whish List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.wishlist-card {
    border: none;
    border-radius: 15px;
    transition: 0.3s;
    background: #fff;
}

.wishlist-card:hover {
    transform: translateY(-8px);
    box-shadow: 0 15px 30px rgba(0,0,0,0.15);
}

.product-img {
    height: 220px;
    object-fit: contain;
    padding: 15px;
}

.price {
    font-size: 1.3rem;
    font-weight: bold;
    color: #b12704;
}

.remove-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    background: #fff;
    border-radius: 50%;
    padding: 6px 10px;
    box-shadow: 0 3px 8px rgba(0,0,0,0.2);
}

.remove-btn:hover {
    background: #ff4d4d;
    color: #fff;
}
</style>

</head>
<body>
<div class="container my-5">

<div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="fw-bold">❤️ My Wishlist</h3>
    <a href="GetAllProducts" class="btn btn-outline-dark btn-sm">← Continue Shopping</a>
</div>

<div class="row">

<%
List<projects> list = (List<projects>) request.getAttribute("wishlist");

if(list != null && !list.isEmpty()){
    for(projects p : list){
%>

<div class="col-xl-3 col-lg-4 col-md-6 mb-4">

<div class="card wishlist-card shadow-sm position-relative">

<a href="RemoveWishlist?pid=<%= p.getproduct_id() %>" 
   class="remove-btn text-danger">
   <i class="fa-solid fa-xmark"></i>
</a>

<img src="files/<%= p.getImg() %>" class="card-img-top product-img">

<div class="card-body text-center">

<span class="badge bg-secondary mb-2">
<%= p.getCategory() %>
</span>

<h5 class="fw-semibold">
<%= p.getTitle() %>
</h5>

<div class="my-2">
<span class="price">₹ <%= p.getDiscountPrice() %></span>
</div>

<p class="text-muted small">
Rating: <b class="text-success"><%= p.getRating() %> ★</b>
</p>

<div class="d-grid gap-2">

<a href="AddToCart?pid=<%= p.getproduct_id() %>" 
   class="btn btn-warning fw-bold rounded-pill">
   🛒 Add to Cart
</a>

<a href="viewProduct?id=<%= p.getproduct_id() %>" 
   class="btn btn-outline-dark btn-sm">
   View Details
</a>

</div>

</div>
</div>

</div>

<%
    }
}else{
%>

<div class="text-center py-5">
    <img src="https://cdn-icons-png.flaticon.com/512/4076/4076549.png" width="120">
    <h4 class="mt-3 text-muted">Your Wishlist is Empty 😢</h4>
    <p class="text-muted">Save items you love ❤️</p>
    <a href="GetAllProducts" class="btn btn-warning rounded-pill px-4">
        Browse Products
    </a>
</div>

<% } %>

</div>
</div>
</body>
</html>