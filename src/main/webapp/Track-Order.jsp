<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.OrderDetails" %>

<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>

</head>
<meta charset="UTF-8">
<title>Track Orders</title>
<body>
<div class="container mt-4">

    <h3 class="fw-bold mb-4">🚚 Track Your Orders</h3>

    <%
        List<OrderDetails> list = (List<OrderDetails>) request.getAttribute("orders");

        if(list != null && !list.isEmpty()) {
            for(OrderDetails o : list) {
    %>

    <div class="card p-3 mb-3 shadow-sm">

        <div class="row">

            <div class="col-md-2">
                <img src="<%= request.getContextPath() %>/files/<%= o.getImg() %>"
                     style="width:80px;height:80px;object-fit:contain;">
            </div>

            <div class="col-md-6">

                <h5><%= o.getTitle() %></h5>

                <p class="text-muted"><%= o.getCategory() %></p>

                <p>Order ID: <b><%= o.getOrderId() %></b></p>

                <p>₹ <%= o.getPrice() %></p>

            </div>

            <div class="col-md-4 text-end">

                <span class="badge
                    <%= o.getStatus().equals("Delivered") ? "bg-success" :
                        o.getStatus().equals("Shipped") ? "bg-primary" :
                        "bg-warning text-dark" %>">

                    <%= o.getStatus() %>
                </span>

            </div>

        </div>

    </div>

    <%
            }
        } else {
    %>

    <h5 class="text-muted text-center">No Orders Found</h5>

    <% } %>

</div>
</body>
</html>