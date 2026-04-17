<%@page import="model.projects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="mainLayout.jsp" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
.product-card {
    border: none;
    border-radius: 18px;
    overflow: hidden;
    background: #fff;
    transition: all 0.3s ease;
    position: relative;
}

.badge-set{

  width : 90px;
   background-colour :brown;
   colour : black;
   border-radius: 20px;
   padding-left : 10px;
  
}
.product-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 20px 40px rgba(0,0,0,0.15);
}

.product-img {
    height: 286px;
    width: 100%;
    object-fit: contain;

    background: #f8f9fa;
    transition: 0.3s;
}

.product-card:hover .product-img {
    transform: scale(1.05);
}

card-title {
    font-size: 1.1rem;
    font-weight: 600;
    height: 45px;
    overflow: hidden;
}

.price-new { 
    font-size: 1.4rem;
    font-weight: 800; 
    color: #b12704; 
}

.btn-lg-custom {
    padding: 10px;
    font-size: 0.95rem;
}

.wishlist-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    z-index: 5;
    font-size: 1.4rem;
}

page-btn {
    min-width: 40px;
}
</style>
</head>
<body>
<div class="container my-5">

<%
List<projects> list = (List<projects>) request.getAttribute("Products");

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>

<!--  SORT -->
<div class="row mb-4 align-items-center">

    <div class="col-md-6">
        <h4 class="fw-bold">🛍 All Products</h4>
    </div>

    <div class="col-md-6 text-end">

        <form action="Products" method="get">

            <select name="sort" class="form-select w-auto d-inline shadow-sm">

                <option value="">Sort By</option>
                <option value="low">Price Low → High</option>
                <option value="high">Price High → Low</option>
                <option value="rating">Top Rated</option>
                <option value="newest">Newest</option>

            </select>

            <button class="btn btn-warning btn-sm ms-2">Apply</button>

        </form>

    </div>

</div>

<!-- PRODUCTS -->
<div class="row">

<%
if(list != null && !list.isEmpty()){
    for(projects p : list){
%>

<div class="col-xl-4 col-lg-4 col-md-6 mb-4">

    <div class="card product-card shadow-sm">

        <!--  WISHLIST -->
        <a href="AddToWishlist?pid=<%= p.getproduct_id() %>" class="text-danger wishlist-btn">
            <i class="fa-regular fa-heart"></i>
        </a>

        <!-- IMAGE -->
        <img src="<%= request.getContextPath() %>/files/<%= p.getImg() %>" 
             class="product-img">

        <div class="card-body d-flex flex-column p-3">

            <span class="badge-set bg-secondary mb-2">
                <%= p.getCategory() %>
            </span>

            <h5 class="card-title"><%= p.getTitle() %></h5>

            <!-- PRICE -->
            <div class="my-2">

                <span class="price-new">₹<%= p.getDiscountPrice() %></span>

                <span class="text-muted ms-2">
                    <del>₹<%= p.getPrice() %></del>
                </span>

                <span class="text-success ms-2 fw-bold">
                    <%
                    double price = p.getPrice();
                    double dp = p.getDiscountPrice();
                    int discount = (int)(((price - dp) / price) * 100);
                    %>
                    <%= discount %>% OFF
                </span>

            </div>

            <p class="text-muted small">
                Rating: <b class="text-success"><%= p.getRating() %> ★</b>
            </p>

            <div class="mt-auto">

                <a href="viewProduct?id=<%= p.getproduct_id() %>" 
                   class="btn btn-outline-dark btn-sm">
                   View
                </a>

                <a href="AddToCart?pid=<%= p.getproduct_id() %>"
                   class="btn btn-warning btn-lg-custom w-100 mt-2 rounded-pill">
                   Add to Cart
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
    <h4>No Products Found 😢</h4>
</div>

<%
}
%>

</div>

<!--  PAGINATION -->
<%
int totalPages = request.getAttribute("totalPages") != null ? (int)request.getAttribute("totalPages") : 1;
int currentPage = request.getAttribute("currentPage") != null ? (int)request.getAttribute("currentPage") : 1;
%>

<div class="text-center mt-5">

<% 
if(currentPage > 1){ 
%>
    <a href="Home?page=<%= currentPage-1 %>" class="btn btn-dark mx-1">Prev</a>
<% 
}

%>

<% 
for(int i = 1; i <= totalPages; i++){ 

%>

    <a href="Home?page=<%= i %>" 
       class="btn page-btn <%= (i == currentPage) ? "btn-warning" : "btn-outline-dark" %> mx-1">
        <%= i %>
    </a>
    
    
<% } %>

<% if(currentPage < totalPages){ %>
    <a href="Home?page=<%= currentPage+1 %>" class="btn btn-dark mx-1">Next</a>
<% } %>

</div>

</div>
</body>
</html>