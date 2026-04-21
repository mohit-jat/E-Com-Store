<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.USER" %>
 
<%
    USER loggedInUser = (USER) session.getAttribute("user");
    
    String displayName = "Guest";
    if (loggedInUser != null) {
        displayName = loggedInUser.getName(); 
    }
%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dasword</title>
<style>
    
    .dashboard-container {
        font-family: 'Segoe UI', Roboto, sans-serif;
        background-color: #ffffff;
        height: 80vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        text-align: center;
        margin: 0;
    }
    .welcome-msg {
        font-size: 4.5rem; 
        font-weight: 900;
        color: #1a1a1a;
        margin-bottom: 10px;
        text-transform: uppercase;
        letter-spacing: -2px;
        opacity: 0;
        animation: slideDown 0.8s ease forwards;
    }

    .user-highlight {
        color: #2563eb; 
        display: block; 
    }

    .sub-text {
        font-size: 1.1rem;
        color: #64748b;
        margin-bottom: 40px;
        opacity: 0;
        animation: fadeIn 1.2s ease forwards 0.5s;
    }

    .btn-container {
        opacity: 0;
        animation: fadeInUp 0.8s ease forwards 0.8s;
    }

    .main-shop-btn {
        position: relative;
        padding: 18px 45px;
        font-size: 1.1rem;
        font-weight: 700;
        color: white;
        background: #2563eb;
        border: none;
        border-radius: 12px;
        text-decoration: none;
        display: inline-block;
        transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        box-shadow: 0 10px 25px rgba(37, 99, 235, 0.3);
    }

    .main-shop-btn:hover {
        transform: scale(1.1) translateY(-5px);
        background: #1d4ed8;
        box-shadow: 0 15px 35px rgba(37, 99, 235, 0.5);
    }

    .main-shop-btn:active {
        transform: scale(0.95);
    }

    @keyframes slideDown {
        from { opacity: 0; transform: translateY(-50px); }
        to { opacity: 1; transform: translateY(0); }
    }

    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(30px); }
        to { opacity: 1; transform: translateY(0); }
    }

    @keyframes fadeIn {
        to { opacity: 1; }
    }

    @media (max-width: 768px) {
        .welcome-msg { font-size: 2.8rem; }
    }
</style>
</head>
<body>
<div class="dashboard-container">
    <h1 class="welcome-msg">
        WELCOME, <br>
        <span class="user-highlight"><%= displayName %></span>
    </h1>
    
    <p class="sub-text">Everything you love, all in one place.</p>

    <div class="btn-container">
        <a href="Home" class="main-shop-btn">
            START YOUR SHOPPING JOURNEY
        </a>
    </div>
</div>
</body>
</html>