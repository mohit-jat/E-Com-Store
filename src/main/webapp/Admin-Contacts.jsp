<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Contact" %>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Contacts</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.card-box{
    border-radius:15px;
    transition:0.3s;
}

.card-box:hover{
    transform:translateY(-5px);
    box-shadow:0 10px 20px rgba(0,0,0,0.15);
}

.badge-email{
    background:#0d6efd;
}
</style>

</head>

<body>

<div class="container mt-5">

    <h2 class="mb-4 fw-bold">📩 Admin Contact Messages</h2>

<%
List<Contact> list = (List<Contact>) request.getAttribute("contacts");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(list != null && !list.isEmpty()){
    for(Contact c : list){
%>

    <div class="card card-box mb-3 p-3">

        <div class="d-flex justify-content-between">
            <h5><%= c.getName() %></h5>
            <span class="badge badge-email"><%= c.getEmail() %></span>
        </div>

        <p class="mt-2"><%= c.getMessage() %></p>

        <small class="text-muted">📅 <%= c.getCreatedAt() %></small>

        <div class="mt-3">
            <button class="btn btn-success btn-sm">Reply</button>
            <button class="btn btn-danger btn-sm">Delete</button>
        </div>

    </div>

<%
    }
} else {
%>
  <h4 class="text-center text-muted">No Messages Found 😢</h4>

<%
}
%>

</div>

</body>
</html>
