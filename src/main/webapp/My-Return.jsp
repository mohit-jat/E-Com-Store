<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.OrderDetails" %>

<%@ include file="mainLayout.jsp" %>
<!DOCTYPE html>
<html>
<head>
</head>

<meta charset="UTF-8">
<title>My Return</title> 
<body>

<div class="container mt-4">
    <h3 class="fw-bold mb-4">🔄 My Returns / Refunds</h3>

    <%
        List<OrderDetails> list = (List<OrderDetails>)request.getAttribute("returns");

        if(list != null && !list.isEmpty()) {
            for(OrderDetails o : list) {
    %>

    <div class="card mb-3 shadow-sm p-3">

        <div class="row align-items-center">

            <div class="col-md-2 text-center">
                <img src="<%= request.getContextPath() %>/files/<%= o.getImg() %>" 
                     style="width:80px;height:80px;object-fit:contain;">
            </div>

            <div class="col-md-6">

                <h5><%= o.getTitle() %></h5>
                <p class="text-muted"><%= o.getCategory() %></p>

                <p>Order ID: <b><%= o.getOrderId() %></b></p>

                <span class="badge 
                    <%= o.getStatus().equals("Requested") ? "bg-warning text-dark" :
                        o.getStatus().equals("Approved") ? "bg-success" :
                        o.getStatus().equals("Rejected") ? "bg-danger" : "bg-secondary" %>">

                    <%= o.getStatus() %>
                </span>

            </div>

            <div class="col-md-4 text-end">

                <% if(o.getStatus().equals("Delivered")) { %>

                    <a href="ReturnRequest?id=<%= o.getOrderId() %>" 
                       class="btn btn-warning btn-sm">
                        Request Return
                    </a>

                <% } else { %>

                    <button class="btn btn-secondary btn-sm" disabled>
                        Not Available
                    </button>

                <% } %>

            </div>

        </div>

    </div>

    <%
            }
        } else {
    %>

    <div class="text-center mt-5">
        <h5>No Return Requests Found 😢</h5>
    </div>

    <% } %>

</div>
</body>
</html>