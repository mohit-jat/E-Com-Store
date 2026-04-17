<%@page import="model.projects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="mainLayout.jsp" %>

<%
projects p = (projects) request.getAttribute("product");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View More</title>
<style>
body { background-color: #f8f9fa; }

.product-container {
    background: white;
    border-radius: 15px;
    box-shadow: 0 8px 25px rgba(0,0,0,0.08);
}
.alert-warning {
    background: #fff3cd;
    border: none;
    font-size: 14px;
}

.view-img {
    max-height: 400px;
    object-fit: contain;
    padding: 20px;
    transition: transform 0.4s ease;
}

.view-img:hover {
    transform: scale(1.08);
}

.price-text {
    font-size: 1.8rem;
    color: #B12704;
    font-weight: bold;
}

.btn-custom {
    border-radius: 25px;
    font-weight: 600;
}

.btn-cart {
    background: #FFD814; 
   }
.btn-wish {
    border: 1px solid #dc3545; 
    color: #dc3545; 
   }
.btn-edit {
    background: #0dcaf0; 
    color: white;
    }
   
.btn-delete {
    background: #dc3545; 
    color: white;
    }
</style>
</head>
<body>

<div class="container my-5">

<% if(p != null){ %>

<div class="product-container p-4">
    <div class="row">

        <div class="col-md-6 text-center border-end">
            <img src="files/<%= p.getImg() %>" class="img-fluid view-img">
        </div>

        <div class="col-md-6 ps-md-4 mt-3 mt-md-0">

            <h3 class="fw-bold"><%= p.getTitle() %></h3>
            <p class="text-muted">Brand: <b><%= p.getBrand() %></b></p>

            <span class="badge bg-secondary"><%= p.getCategory() %></span>


<%
    int stock = p.getStock();
%>

<% if(stock > 0 && stock <= 5){ %>

    <div class="alert alert-warning mt-2 p-2 rounded-3">

        <b>⚡ Limited Offer!</b><br>

        <span class="text-danger fw-bold">
            Hurry up! Only <%= stock %> left in stock 😱
        </span>

    </div>

<% } %>
           <div class="my-3">

    <span class="price-text">₹<%= p.getDiscountPrice() %></span>

    <span class="text-muted ms-2">
        <del>₹<%= p.getPrice() %></del>
    </span>

    <span class="text-success fw-bold ms-2">
        <%
            double price = p.getPrice();
            double dp = p.getDiscountPrice();
            int discount = (int)(((price - dp) / price) * 100);
        %>
        <%= discount %>% OFF
    </span>

    <br>

    <span class="text-danger small">
        Save ₹<%= (int)(p.getPrice() - p.getDiscountPrice()) %>
    </span>

</div>

            <p><b>Rating:</b> <%= p.getRating() %> ★</p>
            <p class="text-secondary"><%= p.getDescription() %></p>

            <% if(p.getStock() > 0){ %>
                <h6 class="text-success">✔ In Stock</h6>
            <% } else { %>
                <h6 class="text-danger">❌ Out of Stock</h6>
            <% } %>

            <div class="row mt-4 g-2">

                <div class="col-6">
                    <a href="AddToCart?pid=<%= p.getproduct_id() %>"
                   class="btn btn-warning btn-lg-custom w-100 mt-2 rounded-pill">
                   Add to Cart
                </a>
                </div>

                <div class="col-6">
                    <a href="AddToWishlist?pid=<%= p.getproduct_id()%>" class="btn btn-wish btn-custom w-100">
                        Wishlist
                    </a>
                </div>

            </div>

        </div>
    </div>
</div>

<% } else { %>

<div class="text-center mt-5">
    <h2 class="text-danger">Product not found</h2>
</div>

<% } %>

</div>
</body>
</html>