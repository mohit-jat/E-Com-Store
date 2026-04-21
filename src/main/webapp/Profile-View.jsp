<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page import="model.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="mainLayout.jsp" %>

<%
Products p = (Products) request.getAttribute("product");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= (p != null) ? p.getTitle() : "View More" %></title>
<style>
    body { background-color: #f8f9fa; }
    .product-container { background: white; border-radius: 15px; box-shadow: 0 8px 25px rgba(0,0,0,0.08); }
    .view-img { max-height: 400px; object-fit: contain; padding: 20px; transition: transform 0.4s ease; }
    .view-img:hover { transform: scale(1.08); }
    .price-text { font-size: 1.8rem; color: #B12704; font-weight: bold; }
    .btn-custom { border-radius: 25px; font-weight: 600; }
    .btn-wish { border: 1px solid #dc3545; color: #dc3545; }

    .star-rating {
        display: flex;
        flex-direction: row-reverse;
        justify-content: flex-end;
    }
    .star-rating input { display: none; }
    .star-rating label {
        font-size: 2.2rem;
        color: #ddd;
        cursor: pointer;
        transition: all 0.2s ease;
        margin-right: 5px;
    }
    .star-rating input:checked ~ label { color: #ffc107; }
    .star-rating label:hover, .star-rating label:hover ~ label { color: #ffdb70; }

    .review-card { border: none; border-radius: 15px; background: #fff; }
    .comment-area { border: 1px solid #eee; border-radius: 10px; resize: none; font-size: 14px; }
    .comment-area:focus { border-color: #ffc107; box-shadow: 0 0 0 0.2rem rgba(255, 193, 7, 0.1); }
    
    .review-scroll { max-height: 350px; overflow-y: auto; padding-right: 5px; }
    .review-scroll::-webkit-scrollbar { width: 5px; }
    .review-scroll::-webkit-scrollbar-thumb { background: #eee; border-radius: 10px; }
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
            <span class="badge bg-secondary mb-3"><%= p.getCategory() %></span>

            <div class="my-3">
                <span class="price-text">₹<%= p.getDiscountPrice() %></span>
                <span class="text-muted ms-2"><del>₹<%= p.getPrice() %></del></span>
                <span class="text-success fw-bold ms-2">
                    <%
                        double price = p.getPrice();
                        double dp = p.getDiscountPrice();
                        int discount = (int)(((price - dp) / price) * 100);
                    %>
                    <%= discount %>% OFF
                </span>
            </div>

            <p class="fs-5">
                <b>Rating:</b> 
                <span class="badge bg-warning text-dark">
                    <%= String.format("%.1f", p.getRating()) %> ★
                </span>
            </p>
            
            <p class="text-secondary"><%= p.getDescription() %></p>

            <% if(p.getStock() > 0){ %>
                <h6 class="text-success">✔ In Stock (<%= p.getStock() %> left)</h6>
            <% } else { %>
                <h6 class="text-danger">❌ Out of Stock</h6>
            <% } %>

            <div class="row mt-4 g-2">
                <div class="col-6">
                    <a href="AddToCart?pid=<%= p.getproduct_id() %>" class="btn btn-warning w-100 rounded-pill fw-bold">Add to Cart</a>
                </div>
                <div class="col-6">
                    <a href="AddToWishlist?pid=<%= p.getproduct_id()%>" class="btn btn-wish btn-custom w-100">Wishlist</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container mt-5 px-0">
    <div class="row justify-content-center">
        <div class="col-md-12">
            
            <% if(request.getParameter("msg") != null) { %>
                <div class="alert alert-success border-0 shadow-sm rounded-pill text-center mb-4 py-2">
                    <i class="fa-solid fa-circle-check me-2"></i> Review posted & rating updated!
                </div>
            <% } %>

            <div class="card review-card shadow-sm overflow-hidden">
                <div class="card-body p-0">
                    <div class="row g-0">
                        
                        <div class="col-md-5 p-4 border-end bg-white">
                            <h5 class="fw-bold mb-4">Rate this product</h5>
                            
                            <% if(session.getAttribute("userId") != null) { %>
                                <form action="AddReview" method="post">
                                    <input type="hidden" name="pid" value="<%= p.getproduct_id() %>">
                                    <input type="hidden" name="uid" value="<%= session.getAttribute("userId") %>">
                                    
                                    <div class="mb-4">
                                        <label class="small fw-bold text-muted d-block mb-2">How was your experience?</label>
                                        <div class="star-rating">
                                            <input type="radio" id="star5" name="rating" value="5" required/><label for="star5">★</label>
                                            <input type="radio" id="star4" name="rating" value="4" /><label for="star4">★</label>
                                            <input type="radio" id="star3" name="rating" value="3" /><label for="star3">★</label>
                                            <input type="radio" id="star2" name="rating" value="2" /><label for="star2">★</label>
                                            <input type="radio" id="star1" name="rating" value="1" /><label for="star1">★</label>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <label class="small fw-bold text-muted mb-2">Write a Comment</label>
                                        <textarea name="comment" class="form-control comment-area shadow-sm" rows="4" placeholder="What did you like or dislike?" required></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-dark w-100 py-2 rounded-pill fw-bold shadow">Submit Review</button>
                                </form>
                            <% } else { %>
                                <div class="text-center py-5">
                                    <i class="fa-solid fa-lock fa-3x text-light mb-3"></i>
                                    <p class="text-muted small">Please login to rate this product</p>
                                    <a href="Login.jsp" class="btn btn-outline-primary btn-sm px-4 rounded-pill">Login Now</a>
                                </div>
                            <% } %>
                        </div>

                        <div class="col-md-7 p-4 bg-light">
                            <h5 class="fw-bold mb-4">Customer Reviews</h5>
                            <div class="review-scroll">
                                <%
                                    List<model.Review> rList = (List<model.Review>) request.getAttribute("reviewList");
                                    if(rList != null && !rList.isEmpty()) {
                                        for(model.Review rev : rList) {
                                %>
                                    <div class="bg-white p-3 rounded-3 shadow-sm mb-3">
                                        <div class="d-flex align-items-center mb-2">
                                            <div class="bg-primary text-white rounded-circle d-flex align-items-center justify-content-center me-2 shadow-sm" style="width: 32px; height: 32px; font-weight: bold; font-size: 0.8rem;">
                                                <%= rev.getUserName().substring(0,1).toUpperCase() %>
                                            </div>
                                            <div class="flex-grow-1">
                                                <div class="d-flex justify-content-between">
                                                    <b class="text-dark small"><%= rev.getUserName() %></b>
                                                    <div class="text-warning small" style="font-size: 11px;">
                                                        <% for(int i=1; i<=5; i++) { %>
                                                            <%= (i <= rev.getRating()) ? "★" : "☆" %>
                                                        <% } %>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <p class="text-muted mb-0 ps-1" style="font-size: 0.85rem; line-height: 1.5;">
                                            <%= rev.getComment() %>
                                        </p>
                                    </div>
                                <% 
                                        }
                                    } else { 
                                %>
                                    <div class="text-center py-5">
                                        <img src="https://cdn-icons-png.flaticon.com/512/1368/1368593.png" width="50" class="mb-2 opacity-25">
                                        <p class="text-muted small italic">No reviews yet. Be the first to rate!</p>
                                    </div>
                                <% } %>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<% } else { %>
<div class="text-center mt-5">
    <div class="alert alert-danger d-inline-block px-5 rounded-pill">
        <h4 class="mb-0">Product not found!</h4>
    </div>
</div>
<% } %>

</div>
</body>
</html>