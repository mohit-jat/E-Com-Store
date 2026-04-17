>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f6fa;
}

.address-card{
    border-radius:15px;
    transition:0.3s;
    border:none;
}

.address-card:hover{
    transform:translateY(-5px);
    box-shadow:0 10px 25px rgba(0,0,0,0.15);
}

.title{
    font-weight:700;
    font-size:18px;
}

.small-text{
    color:#6c757d;
    font-size:14px;
}

.form-box{
    background:white;
    padding:20px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,0.05);
}

</style>

</head>

<body>

<div class="container mt-4">

    <h3 class="fw-bold mb-4">🏠 Saved Addresses</h3>

    <div class="row">

        <!-- ================= ADD NEW ADDRESS ================= -->
        <div class="col-lg-5 mb-4">

            <div class="form-box">

                <h5 class="fw-bold mb-3">➕ Add New Address</h5>

                <form action="Address" method="post">

                    <input name="name" class="form-control mb-2" placeholder="Full Name" required>

                    <input name="mobile" class="form-control mb-2" placeholder="Mobile Number" required>

                    <textarea name="address" class="form-control mb-2" placeholder="Full Address" required></textarea>

                    <input name="city" class="form-control mb-2" placeholder="City" required>

                    <input name="pincode" class="form-control mb-3" placeholder="Pincode" required>

                    <button class="btn btn-success w-100">
                        Save Address
                    </button>

                </form>

            </div>

        </div>

        <!-- ================= SAVED ADDRESSES LIST ================= -->
        <div class="col-lg-7">

            <h5 class="fw-bold mb-3">📍 Your Saved Addresses</h5>

            <%

                List<String> dummy = new ArrayList<>();

                if(dummy != null && !dummy.isEmpty()) {

                    for(String a : dummy) {

            %>

            <div class="card address-card p-3 mb-3">

                <div class="title">John Doe</div>

                <div class="small-text">9876543210</div>

                <div class="mt-2">
                    123 Street, Near Market, City Name - 123456
                </div>

                <div class="mt-3">

                    <a href="SelectAddress?id=1" class="btn btn-primary btn-sm">
                        Select
                    </a>

                    <a href="DeleteAddress?id=1" class="btn btn-danger btn-sm">
                        Delete
                    </a>

                </div>

            </div>

            <%

                    }

                } else {
            %>

            <div class="text-center text-muted mt-5">
                No saved address found 😢
            </div>

            <% } %>

        </div>

    </div>

</div>

</body>
</html>