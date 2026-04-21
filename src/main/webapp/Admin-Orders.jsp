<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.OrderDetails" %>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Orders</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.order-card{
    border-radius:15px;
    transition:0.3s;
}
.order-card:hover{
    transform:translateY(-5px);
    box-shadow:0 10px 25px rgba(0,0,0,0.15);
}

.order-img{
    width:100px;
    height:100px;
    object-fit:contain;
}

.badge{
    font-size:13px;
}
</style>

</head>

<body>

<div class="container mt-5">

    <h3 class="mb-4 fw-bold">📦 Admin Order Panel</h3>

    <div class="row">

<%
    List<OrderDetails> list = (List<OrderDetails>) request.getAttribute("orders");

    if(list != null && !list.isEmpty()){
        for(OrderDetails o : list){
%>

    <div class="col-md-6 mb-4">
        <div class="card order-card p-3 shadow">

            <div class="d-flex">

                <img src="<%= request.getContextPath() %>/files/<%= o.getImg() %>"
                     class="order-img me-3">

                <div class="w-100">

                    <h5><%= o.getTitle() %></h5>
                    <p class="text-muted"><%= o.getCategory() %></p>

                    <p>Qty: <b><%= o.getQuantity() %></b></p>
                    <p>₹ <%= o.getPrice() %></p>

                    <p>
                        Status:
                        <span class="badge 
                        <%= o.getStatus().equals("Delivered")?"bg-success":
                            o.getStatus().equals("Success")?"bg-primary":
                            "bg-warning text-dark" %>">
                            <%= o.getStatus() %>
                        </span>
                    </p>

                    <p class="small text-muted">
                        📅 <%= o.getOrderDate() %>
                    </p>

                    <div class="mt-2">

                      

                        <a href="UpdateOrderStatus?id=<%= o.getOrderId() %>&status=Delivered"
                           class="btn btn-success btn-sm">
                           Delivered
                        </a>

                        <a href="UpdateOrderStatus?id=<%= o.getOrderId() %>&status=Cancelled"
                           class="btn btn-danger btn-sm">
                           Cancel
                        </a>

                    </div>

                </div>

            </div>

        </div>
    </div>
    
  
<%
        }
    } else {
%>

<div class="text-center mt-5">
    <h4>No Orders Found 😢</h4>
</div>

<%
    }
%>

    </div>
</div>

</body>
</html>