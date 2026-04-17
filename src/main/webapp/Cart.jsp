<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.projects" %>
<%@ include file="mainLayout.jsp" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.cart-card {
    border-radius: 15px;
    transition: 0.3s;
}

.cart-card:hover {
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.product-img {
    width: 80px;
    height: 80px;
    object-fit: contain;
}

.qty-box {
    width: 60px;
    text-align: center;
}

.total-box {
    background: #f8f9fa;
    border-radius: 15px;
    padding: 20px;
}
</style>
</head>
<body>

<div class="container my-5">

<h3 class="fw-bold mb-4">🛒 My Cart</h3>

<div class="row">

<div class="col-lg-8">

<%
List<projects> list = (List<projects>) request.getAttribute("cartList");

double total = 0;

if(list != null && !list.isEmpty()){
for(projects p : list){

double subTotal = p.getDiscountPrice() * p.getStock();
total += subTotal;
%>

<div class="card cart-card mb-3 p-3">

<div class="row align-items-center">

<div class="col-md-2 text-center">
<img src="files/<%= p.getImg() %>" class="product-img">
</div>

<div class="col-md-4">
<h5 class="fw-semibold"><%= p.getTitle() %></h5>
<p class="text-muted small"><%= p.getCategory() %></p>
</div>

<div class="col-md-2 text-center">
<span class="fw-bold text-success">₹ <%= p.getDiscountPrice() %></span>
</div>

<div class="col-md-2 text-center">
<input type="text" class="form-control qty-box" value="<%= p.getStock() %>" readonly>
</div>

<div class="col-md-2 text-center">
<a href="RemoveCart?id=<%= p.getproduct_id() %>" 
   class="btn btn-outline-danger btn-sm">
   Remove
</a>
</div>

</div>

</div>

<%
}
}else{
%>

<div class="text-center py-5">
    <h4 class="text-muted">Your Cart is Empty 😢</h4>
    <a href="AllProducts" class="btn btn-warning mt-3">Shop Now</a>
</div>

<% } %>

</div>

<div class="col-lg-4">

<div class="total-box shadow-sm">

<h5 class="fw-bold mb-3">Price Details</h5>

<hr>

<p>Total Items: <b><%= list != null ? list.size() : 0 %></b></p>

<p>Total Price: <b class="text-success">₹ <%= total %></b></p>

<hr>

<h5 class="fw-bold">Grand Total: 
<span class="text-success">₹ <%= total %></span>
</h5>

<a href="Checkout" class="btn btn-warning w-100 mt-3 fw-bold rounded-pill">
Proceed to Checkout
</a>

</div>

</div>

</div>
</div>
</body>
</html>