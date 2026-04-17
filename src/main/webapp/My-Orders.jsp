
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*, model.OrderDetails" %>
<%@ include file="mainLayout.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY Orders</title>
<style>

body{
    background: #f5f6fa;
}

.order-card {
    border-radius: 20px;
    transition: 0.3s;
    border: none;
}
.order-card:hover {
    transform: translateY(-6px);
    box-shadow: 0 15px 35px rgba(0,0,0,0.12);
}

.order-img {
    width: 120px;
    height: 120px;
    object-fit: contain;
    border-radius: 10px;
    background: #f8f9fa;
    padding: 10px;
}

.title {
    font-weight: 700;
    font-size: 18px;
}

.price {
    font-size: 18px;
    font-weight: 700;
    color: #b12704;
}

.label {
    font-weight: 600;
    color: #555;
}

.info-box {
    background: #f8f9fa;
    border-radius: 10px;
    padding: 10px;
}

.badge {
    font-size: 12px;
    padding: 6px 10px;
    border-radius: 20px;
}

</style>
</head>
<body>
<div class="container mt-5">

    <h3 class="fw-bold mb-4">🛒 My Orders</h3>

    <div class="row">

   <%
    List<OrderDetails> list = (List<OrderDetails>) request.getAttribute("orders");

    if(list != null && !list.isEmpty()) {
        for(OrderDetails o : list) {
%>

<div class="col-lg-6 mb-4">
    <div class="card order-card p-3 shadow-sm">

        <div class="row align-items-center">

            <div class="col-md-4 text-center">
                <img src="<%= request.getContextPath() %>/files/<%= o.getImg() %>" 
                     class="order-img">
            </div>

            <div class="col-md-8">

                <div class="title mb-1"><%= o.getTitle() %></div>

                <div class="text-muted small mb-2"><%= o.getCategory() %></div>

                <div class="price mb-2">₹ <%= o.getPrice() %></div>

                <div class="info-box mb-2">
                    <div class="d-flex justify-content-between">
                        <span class="label">Quantity</span>
                        <span><%= o.getQuantity() %></span>
                    </div>

                    <div class="d-flex justify-content-between">
                        <span class="label">Payment</span>
                        <span><%= o.getPaymentType() %></span>
                    </div>
                </div>

                <div class="mb-2">
                    <span class="label">Status:</span>

                    <span class="badge 
                        <%= o.getStatus().equalsIgnoreCase("Delivered") ? "bg-success" : 
                            o.getStatus().equalsIgnoreCase("Pending") ? "bg-warning text-dark" : 
                            "bg-secondary" %>">

                        <%= o.getStatus() %>
                    </span>
                </div>

                <div class="small text-muted">
                    Ordered on: <%= o.getOrderDate() %>
                </div>

                <a href="ReturnRequest?id=<%= o.getOrderId() %>" 
                   class="btn btn-warning btn-sm mt-2">
                   Return / Refund
                </a>

            </div>

        </div>

    </div>
</div>

<%
        }
    } else {
%>
   

    <div class="col-12 text-center mt-5">

        <h4 class="text-muted">No Orders Found 😢</h4>

        <a href="GetAllProducts" class="btn btn-warning mt-3 px-4 rounded-pill fw-bold">
            🛍 Shop Now
        </a>

    </div>

    <% } %>

    </div>
</div>
</body>
</html>