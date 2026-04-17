<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Settings</title>
    <style>

    body { 
     font-family: Arial;
     background:#f5f5f5;
     }
   
    .container {
     width: 400px;
     margin: 40px auto;
     background:white;
     padding:20px; 
     border-radius:10px;
     }
 
 h2 { 
    text-align:center; 
    }
  
    .item { 
    padding:12px; 
    border-bottom:1px solid #ddd;
    cursor:pointer;
 
     }      
    
     .item a {
     text-decoration: none; 
     color: black;
     display: block; 
    
    }
   
    .item a:hover { 
     color: #007bff;
    
     }
  
    .item:hover { 
     background:#f0f0f0;
   
     }
  
    .btn { 
     width:100%;
     padding:10px;
     margin-top:10px;
     background:black; 
     color:white;
     border:none;
    
     }
    
    </style>
</head>
<body>

<div class="container">
    <h2>⚙️ Settings</h2>

    <div class="item"><a href="Profile">👤 Profile Settings</a></div>
    <div class="item"><a href="Address">📍 Manage Address</a></div>
    <div class="item"><a href="MyOrders">📦 My Orders</a></div>
    <div class="item"><a href="TrackOrder"> Track Order</a></div>
    <div class="item"><a href="Contact">🌐 Contact</a></div>
    <div class="item"><a href="Help">📞 Help / Support</a></div>

    <form action="Logout" method="post">
        <button class="btn">Logout</button>
    </form>
</div>

</body>
</html>
