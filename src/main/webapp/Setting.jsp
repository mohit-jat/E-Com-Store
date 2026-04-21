<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<!DOCTYPE html>
<html>
<head>
<title>Settings</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

/* RESET */
* {
    box-sizing: border-box;
}

body {
    font-family: Arial;
    background: #f5f5f5;
    margin: 0;
}

/* CONTAINER */
.container {
    width: 100%;
    max-width: 420px;
    margin: 40px auto;
    background: white;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 5px 20px rgba(0,0,0,0.1);
}

/* TITLE */
h2 {
    text-align: center;
    margin-bottom: 20px;
}

/* ITEMS */
.item {
    padding: 14px;
    border-bottom: 1px solid #eee;
    cursor: pointer;
    transition: 0.2s;
}

.item a {
    text-decoration: none;
    color: black;
    display: block;
}

/* HOVER */
.item:hover {
    background: #f0f0f0;
}

.item a:hover {
    color: #007bff;
}

/* BUTTON */
.btn {
    width: 100%;
    padding: 12px;
    margin-top: 15px;
    background: black;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 15px;
}

/* 🔥 MOBILE FIX */
@media (max-width: 480px) {
    .container {
        margin: 20px 10px;
        padding: 15px;
    }

    .item {
        padding: 12px;
        font-size: 14px;
    }

    h2 {
        font-size: 18px;
    }
}

</style>
</head>

<body>

<div class="container">

    <h2>⚙️ Settings</h2>

    <div class="item"><a href="Profile">👤 Profile Settings</a></div>
    <div class="item"><a href="Address">📍 Manage Address</a></div>
    <div class="item"><a href="MyOrders">📦 My Orders</a></div>
    <div class="item"><a href="TrackOrder">🚚 Track Order</a></div>
    <div class="item"><a href="Contact">🌐 Contact</a></div>
    <div class="item"><a href="Help">📞 Help / Support</a></div>

    <form action="Logout" method="post">
        <button class="btn">Logout</button>
    </form>

</div>

</body>
</html>