<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.projects" %>
<%@ include file="mainLayout.jsp" %>

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
List<projects> list = (List<projects>) request.getAttribute("productList");

if(list != null && !list.isEmpty()){
    for(projects p : list){
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