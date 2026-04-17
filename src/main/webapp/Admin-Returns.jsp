<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.OrderDetails" %>

<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return Requests</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.card-custom{
    border-radius:15px;
    transition:0.3s;
}

.card-custom:hover{
    transform:translateY(-5px);
    box-shadow:0 10px 25px rgba(0,0,0,0.15);
}

.badge{
    font-size:13px;
    padding:6px 12px;
    border-radius:20px;
}

</style>

</head>

<body>

<div class="container mt-5">

    <h3 class="fw-bold mb-4">🔄 Return Requests Panel</h3>

    <div class="row">

<%
List<OrderDetails> list = (List<OrderDetails>) request.getAttribute("returns");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(list != null && !list.isEmpty()){
    for(OrderDetails o : list){
%>

    <div class="col-md-6 mb-4">

        <div class="card card-custom p-3 shadow-sm">

            <div class="d-flex justify-content-between align-items-center">

                <div>
                    <h5 class="mb-1">Order #<%= o.getOrderId() %></h5>
                    <p class="text-muted mb-1">User ID: <%= o.getUserId() %></p>
                </div>

                <span class="badge 
                    <%= o.getStatus().equalsIgnoreCase("Requested") ? "bg-warning text-dark" :
                        o.getStatus().equalsIgnoreCase("Approved") ? "bg-success" :
                        "bg-danger" %>">

                    <%= o.getStatus() %>
                </span>

            </div>

            <hr>

            <div class="d-flex justify-content-end gap-2">

                <a href="ApproveReturn?id=<%= o.getOrderId() %>" 
                   class="btn btn-success btn-sm">
                   ✔ Approve Refund
                </a>

                <a href="RejectReturn?id=<%= o.getOrderId() %>" 
                   class="btn btn-danger btn-sm">
                   ✖ Reject
                </a>

            </div>

        </div>

    </div>

<%
    }
} else {
%>

    <div class="text-center mt-5">
        <h4 class="text-muted">No Return Requests 😢</h4>
    </div>

<%
}
%>

    </div>
</div>

</body>
</html>