<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*,model.Products" %>

 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<%@ include file="mainLayout.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckOut</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.checkout-box {
    background: #fff;
    border-radius: 15px;
    padding: 20px;
    transition: 0.3s;
}

.checkout-box:hover {
    box-shadow: 0 8px 25px rgba(0,0,0,0.08);
}

.product-img {
    width: 60px;
    height: 60px;
    object-fit: contain;
    border-radius: 10px;
}

.place-btn {
    transition: 0.3s;
}

.place-btn:hover {
    transform: scale(1.02);
}
</style>
</head>
<body>
<div class="container my-5">

<h3 class="fw-bold mb-4">🧾 Secure Checkout</h3>

<form action="PlaceOrder" method="Post">

<div class="row">

<div class="col-lg-7">

<div class="checkout-box shadow-sm mb-4">

<h5 class="fw-bold mb-3">📍 Shipping Address</h5>

<textarea name="address" class="form-control mb-3"
placeholder="Enter full address (House No, Street, City, Pincode)" required></textarea>

<input type="text" name="phone" class="form-control mb-3"
placeholder="Enter phone number" required>

<div class="form-check mt-2">
  <input class="form-check-input" type="checkbox" required>
  <label class="form-check-label">
    I confirm my address is correct
  </label>
</div>

</div>

<div class="checkout-box shadow-sm">

<h5 class="fw-bold mb-3">💳 Payment Method</h5>

<div class="form-check mb-2">
  <input class="form-check-input" type="radio" name="payment" value="Cash On Delivery" checked>
  <label class="form-check-label">Cash On Delivery</label>
</div>

<div class="form-check mb-2">
  <input class="form-check-input" type="radio" name="payment" value="UPI">
  <label class="form-check-label">UPI (PhonePe / GPay)</label>
</div>

<div class="form-check">
  <input class="form-check-input" type="radio" name="payment" value="Card">
  <label class="form-check-label">Debit / Credit Card</label>
</div>

</div>

</div>

<div class="col-lg-5">

<div class="checkout-box shadow-sm">

<h5 class="fw-bold mb-3">🛒 Order Summary</h5>

<hr>

<%
List<Products> list = (List<Products>) request.getAttribute("cartList");
double total = 0;

if(list != null && !list.isEmpty()){
for(Products p : list){

double sub = p.getDiscountPrice() * p.getStock();
total += sub;
%>

<div class="d-flex align-items-center mb-3">

<img src="files/<%= p.getImg() %>" class="product-img me-3">

<div>
<p class="mb-0 fw-semibold"><%= p.getTitle() %></p>
<small class="text-muted">Qty: <%= p.getStock() %></small>
</div>

<div class="ms-auto fw-bold text-success">
₹ <%= sub %>
</div>

</div>

<% } } else { %>

<p class="text-muted">No items in cart</p>

<% } %>

<hr>

<h5 class="fw-bold text-dark">
💰 Grand Total:
<span class="text-success">₹ <%= total %></span>
</h5>

<p class="text-muted small mt-2">
🚚 Estimated Delivery: 3-5 Days
</p>

<div class="text-center my-3">
  <small class="text-muted">
    🔒 Secure Checkout | ⚡ Fast Processing | 📦 Safe Delivery
  </small>
</div>

<button class="btn btn-success w-100 mt-3 fw-bold rounded-pill place-btn"
        onclick="this.disabled=true; this.form.submit();">
🚀 Place Order
</button>

</div>

</div>

</div>

</form>

</div>
</body>
</html>