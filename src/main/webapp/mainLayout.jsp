<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.USER" %>


<% 
USER currentUser = (USER) session.getAttribute("user");
String role = (currentUser != null) ? currentUser.getRole() : "GUEST";
%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

   %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>

  .navbar { 
  background: #131921 !important; 
  padding: 0.6rem 1rem;
   }
  /* sirf navbar search pe apply hoga */
.navbar .form-control{
   margin-left: 0;
}
  body.dark {
   background: #0f172a; 
   color: white; 
  }

   body.dark .navbar {
   background: #0b1220 !important; 
  }
 
  body.dark .sidebar { 
  background: #1e293b; 
 
  }
body.dark .card { 
   background: #1e293b; 
   color: white;
 
   }

.input-group
{
margin-left:127px;
}
.sidebar {
    height: 100%;
   width: 0;
   position: fixed
  ; z-index: 2000;
    top: 0; 
  left: 0;
   background-color: #fff;
   overflow-x: hidden;    
    transition: 0.3s;
   box-shadow: 4px 0 10px rgba(0,0,0,0.3);
}

.sidebar-header {
    background: #232f3e;
    color: white;
    padding: 15px 20px;
    font-size: 1.2rem;
    font-weight: bold; 
    display: flex;
    justify-content : space-between;
    align-items: center;
}

.sidebar a {
    padding: 12px 20px; 
    text-decoration: none; 
    font-size: 1rem;
    color: #111; 
    display: block;
    border-bottom: 1px solid #eee; 
    transition: 0.2s;
}



.sidebar a:hover { 
     background-color: #f3f3f3;
     color: #ff9f43;
     }
 
 .overlay { 
     display: none;
     position: fixed;
     width: 100%; 
     height: 100%; 
     top: 0; 
      left: 0;
     background: rgba(0,0,0,0.6);
     z-index: 1500; 
    }

.search-btn { 
background: #febd69; 
border: none;
 }
.search-btn:hover {
  background: #f3a847; 
 
    }

.nav-profile-link { 
    color: #fff;
    text-decoration: none;
    font-weight: 500; 
    }

  .nav-profile-link:hover { 
  color: #febd69;   
  
      }
      /* 🔥 MOBILE RESPONSIVE FIX */
@media (max-width: 992px) {

    /* navbar collapse properly */
    .navbar .collapse {
        background: #131921;
        padding: 10px;
    }

    /* search bar full width */
    .navbar form {
        width: 100% !important;
        margin: 10px 0;
    }

    .navbar .input-group {
        width: 100%;
    }

    /* icons center */
    .navbar-nav {
        flex-direction: row;
        justify-content: center;
        width: 100%;
    }

    /* sidebar width adjust */
    .sidebar {
        width: 0;
    }
}

/* 🔥 SMALL MOBILE */
@media (max-width: 576px) {

    .navbar-brand {
        font-size: 16px;
    }

    .navbar .btn,
    .navbar .nav-link {
        font-size: 14px;
    }

    /* icons spacing */
    .navbar-nav .nav-item {
        margin: 0 5px;
    }
}
</style>
</head>
<body>
<div id="mySidebar" class="sidebar">
    <div class="sidebar-header">
        <span><i class="fa-solid fa-user-circle me-2"></i> Menu</span>
        <i class="fa-solid fa-xmark" style="cursor:pointer" onclick="closeNav()"></i>
    </div>

    <div class="py-3">
        <h6 class="px-3 fw-bold text-muted small">SHOP BY CATEGORY</h6>
        <ul class="list-unstyled m-0 p-0">
            <li><a href="Category?type=Electronics"><i class="fa-solid fa-laptop me-2"></i> Electronics</a></li>
            <li><a href="Category?type=Fashion"><i class="fa-solid fa-shirt me-2"></i> Fashion</a></li>
            <li><a href="Category?type=Home"><i class="fa-solid fa-couch me-2"></i> Home Decor</a></li>
            <li><a href="Category?type=Beauty"><i class="fa-solid fa-sparkles me-2"></i> Beauty & Health</a></li>
            <li><a href="Category?type=Mobiles"><i class="fa-solid fa-mobile me-2"></i> Mobiles</a></li>
            <li><a href="Category?type=Laptops"><i class="fa-solid fa-laptop-code me-2"></i> Laptops</a></li>
            <li><a href="Category?type=Sports"><i class="fa-solid fa-basketball me-2"></i> Sports</a></li>
        </ul>
        <hr>

        <h6 class="px-3 fw-bold text-muted small">USER ACCOUNT</h6>
        <a class="nav-profile-link d-flex align-items-center px-3 py-2 text-dark" href="Profile">
            <i class="fa-solid fa-circle-user fs-4 me-2 text-warning"></i> My Profile
        </a>
        <a href="MyOrders" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-box me-2 text-primary"></i> My Orders
        </a>
        <a href="Cart" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-cart-shopping me-2 text-warning"></i> My Cart
        </a>
        <a href="Wishlist" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-heart me-2 text-danger"></i> Wishlist
        </a>
        <hr>
  <a href="TrackOrder" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-truck me-2 text-info"></i> Track Order
        </a>
        <a href="MyReturns" class="d-block px-3 py-2 text-decoration-none text-dark">

           <i class="fa-solid fa-rotate-left me-2 text-warning"></i> Returns & Refunds

            </a>
            <hr>
        <h6 class="px-3 fw-bold text-muted small">SUPPORT & HELP</h6>
        <a href="Help" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-circle-question me-2 text-primary"></i> Help Center
        </a>
        <a href="Contact" class="d-block px-3 py-2 text-decoration-none text-dark">
            <i class="fa-solid fa-envelope me-2 text-success"></i> Contact Us
        </a>
        
        <hr>
        <a href="Setting.jsp" class="d-block px-3 py-2 text-decoration-none text-dark">
    <i class="fa-solid fa-gear me-2 text-secondary"></i> Settings
</a>
        <hr>
      

        <% if ("ADMIN".equals(role)) { %>
            <h6 class="px-3 fw-bold text-danger small">ADMIN PANEL</h6>
            <a href="Add-Products" class="d-block px-3 py-2 text-decoration-none text-dark">
                <i class="fa-solid fa-plus me-2 text-success"></i> Add Product
            </a>
            <a href="ShowProducts" class="d-block px-3 py-2 text-decoration-none text-dark">
                <i class="fa-solid fa-list me-2 text-info"></i> Manage Products
            </a>
            <a href="AdminOrders" class="d-block px-3 py-2 text-decoration-none text-dark">
                <i class="fa-solid fa-boxes-stacked me-2 text-warning"></i> Manage Orders
            </a>
            <a href="AdminContacts" class="d-block px-3 py-2 text-decoration-none text-dark">
                <i class="fa-solid fa-message me-2 text-primary"></i> Contact Messages
            </a>
            <a href="AdminReturnRequests" class="d-block px-3 py-2 text-decoration-none text-dark">
                <i class="fa-solid fa-rotate-left me-2 text-danger"></i> Return Requests
            </a>
            <a href="AdminAnalytics" class="d-block px-3 py-2 text-decoration-none text-dark text-info">
                <i class="fa-solid fa-chart-line me-2"></i> Analytics
            </a>
            <hr>
        <% } %>

        <% if (currentUser != null) { %>
            <a href="Logout" class="d-block px-3 py-2 text-danger" onclick="return confirm('Are you sure you want to logout?')">
                <i class="fa-solid fa-power-off me-2"></i> Logout
            </a>
        <% } else { %>
            <a href="Login.jsp" class="d-block px-3 py-2 text-primary font-weight-bold">
                <i class="fa-solid fa-right-to-bracket me-2"></i> Login / Sign Up
            </a>
        <% } %>
    </div>
</div>

<div id="sidebarOverlay" class="overlay" onclick="closeNav()"></div>

<nav class="navbar navbar-expand-lg navbar-dark sticky-top">
    <div class="container-fluid">
        <button class="btn text-white me-2 border-0" onclick="openNav()">
            <i class="fa-solid fa-bars fs-4"></i>
        </button>
        <a class="navbar-brand text-warning" href="Home">MyStore</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navContent">
    <span class="navbar-toggler-icon"></span>
</button>
        
<div class="collapse navbar-collapse justify-content-between" id="navContent">
            <form class="d-flex mx-auto w-50" action="Search" method="get">
                <div class="input-group">
                    <input class="form-control" type="search" name="key" placeholder="Search items..." 
                           value="<%= request.getParameter("key") != null ? request.getParameter("key") : "" %>">
                    <button class="btn search-btn" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </div>
            </form>

            <ul class="navbar-nav ms-auto align-items-center">
                <li class="nav-item me-3">
                    <button onclick="toggleDarkMode()" class="btn btn-sm btn-outline-warning rounded-pill">🌙</button>
                </li>
                <li class="nav-item me-3"><a class="nav-link" href="Wishlist"><i class="fa-solid fa-heart fs-5 text-danger"></i></a></li>
                <li class="nav-item me-3"><a class="nav-link" href="Cart"><i class="fa-solid fa-cart-shopping fs-5 text-warning"></i></a></li>
                <li class="nav-item">
                    <% if (currentUser != null) { %>
                        <a href="Profile" class="nav-profile-link"><i class="fa-solid fa-circle-user fs-4 text-warning"></i></a>
                    <% } else { %>
                        <a href="Login.jsp" class="btn btn-sm btn-warning fw-bold">Login</a>
                    <% } %>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script>
function openNav() { document.getElementById("mySidebar").style.width = "280px"; 
document.getElementById("sidebarOverlay").style.display = "block";
}

function closeNav() { document.getElementById("mySidebar").style.width = "0"; 
document.getElementById("sidebarOverlay").style.display = "none"; 
}

function toggleDarkMode() {
    document.body.classList.toggle("dark");
    localStorage.setItem("theme", document.body.classList.contains("dark") ? "dark" : "light");
}
window.onload = function () {
    if (localStorage.getItem("theme") === "dark") document.body.classList.add("dark");
}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>