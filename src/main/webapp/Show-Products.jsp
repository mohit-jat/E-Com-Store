<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Products" %>

 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<%@ include file="mainLayout.jsp" %>
<head>
<meta charset="UTF-8">
<title>Products</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

.table img {
    border-radius: 10px;
    max-width: 100%;
    height: auto;
}

@media (max-width: 768px) {

    .table thead {
        display: none;    }

    .table, .table tbody, .table tr, .table td {
        display: block;
        width: 100%;
    }

    .table tr {
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 10px;
        background: #fff;
    }

    .table td {
        text-align: left;
        padding: 8px;
        position: relative;
        padding-left: 50%;
        border: none;
    }

    .table td::before {
        position: absolute;
        left: 10px;
        top: 8px;
        font-weight: bold;
    }

    .table td:nth-of-type(1)::before { content: "ID"; }
    .table td:nth-of-type(2)::before { content: "Image"; }
    .table td:nth-of-type(3)::before { content: "Title"; }
    .table td:nth-of-type(4)::before { content: "Category"; }
    .table td:nth-of-type(5)::before { content: "Brand"; }
    .table td:nth-of-type(6)::before { content: "Price"; }
    .table td:nth-of-type(7)::before { content: "Stock"; }
    .table td:nth-of-type(8)::before { content: "Action"; }

    .table form {
        flex-direction: column;
        gap: 5px;
    }

    .table input {
        width: 100% !important;
    }
}

</style>
</head>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<style>
.table img {
    border-radius: 10px;
}
</style>
</head>
<body>
<div class="container mt-5">

<h3 class="fw-bold mb-4 text-center">📦 Manage Stock</h3>

<table class="table table-bordered table-hover text-center align-middle shadow">

<tr class="table-dark">
    <th>ID</th>
    <th>Image</th>
    <th>Title</th>
    <th>Category</th>
    <th>Brand</th>
    <th>Price</th>
    <th>Stock</th>
    <th>Action</th>
</tr>

<%
List<Products> list = (List<Products>) request.getAttribute("productList");

if(list != null && !list.isEmpty()){
    for(Products p : list){
%>

<tr>
    <td><%= p.getproduct_id() %></td>

    <td>
        <img src="<%= request.getContextPath() %>/files/<%= p.getImg() %>" width="70">
    </td>

    <td><%= p.getTitle() %></td>
    <td><%= p.getCategory() %></td>
    <td><%= p.getBrand() %></td>
    <td>₹<%= p.getPrice() %></td>

    <!-- 🔥 Stock update -->
    <td>
        <form action="UpdateStock" method="post" class="d-flex justify-content-center">
            <input type="hidden" name="id" value="<%= p.getproduct_id() %>">

            <input type="number" name="stock" value="<%= p.getStock() %>" 
                   class="form-control me-2" style="width:80px;">

            <button class="btn btn-success btn-sm">Update</button>
        </form>
    </td>

    <!-- 🔥 Actions -->
    <td>
        <a href="EditProduct?id=<%= p.getproduct_id() %>" 
           class="btn btn-primary btn-sm mb-1">Edit</a>

        <br>

        <a href="DeleteProduct?id=<%= p.getproduct_id() %>" 
           class="btn btn-danger btn-sm"
           onclick="return confirm('Delete this product?')">
           Delete
        </a>
    </td>
</tr>

<% 
    }
} else {
%>

<tr>
    <td colspan="8">
        <h5 class="text-muted">No Products Found 😢</h5>
    </td>
</tr>

<% } %>

</table>

</div>
</body>
</html>