<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Analytics</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.card-box{
    border-radius:20px;
    transition:0.3s;
    border:none;
}

.card-box:hover{
    transform:translateY(-6px);
    box-shadow:0 15px 35px rgba(0,0,0,0.15);
}

.card-title{
    font-size:14px;
    color:#6c757d;
}

.card-value{
    font-size:26px;
    font-weight:bold;
}

.icon-box{
    font-size:30px;
    opacity:0.7;
}

</style>

</head>

<body>

<div class="container mt-5">

    <h3 class="fw-bold mb-4">📊 Admin Dashboard Analytics</h3>

    <div class="row g-4">

        <!-- YEAR SALES -->
        <div class="col-md-3">
            <div class="card card-box p-3 shadow-sm text-center">
                <div class="icon-box text-primary">📅</div>
                <div class="card-title">Year Sales</div>
                <div class="card-value text-primary">
                    ₹ <%= request.getAttribute("yearSales") %>
                </div>
            </div>
        </div>

        <!-- MONTH SALES -->
        <div class="col-md-3">
            <div class="card card-box p-3 shadow-sm text-center">
                <div class="icon-box text-success">📆</div>
                <div class="card-title">Month Sales</div>
                <div class="card-value text-success">
                    ₹ <%= request.getAttribute("monthSales") %>
                </div>
            </div>
        </div>

        <!-- TOP PRODUCT -->
        <div class="col-md-3">
            <div class="card card-box p-3 shadow-sm text-center">
                <div class="icon-box text-warning">🏆</div>
                <div class="card-title">Top Product</div>
                <div class="card-value text-warning">
                    <%= request.getAttribute("topProduct") %>
                </div>
            </div>
        </div>

        <!-- TOP CATEGORY -->
        <div class="col-md-3">
            <div class="card card-box p-3 shadow-sm text-center">
                <div class="icon-box text-danger">🏷️</div>
                <div class="card-title">Top Category</div>
                <div class="card-value text-danger">
                    <%= request.getAttribute("topCategory") %>
                </div>
            </div>
        </div>

    </div>

    <!-- EXTRA SECTION -->
    <div class="mt-5">

        <div class="card p-4 shadow-sm">
            <h5 class="fw-bold mb-3">📈 Insights</h5>

            <p> Total yearly performance overview</p>
            <p> Monthly revenue tracking</p>
            <p> Most popular product</p>
            <p> Best performing category</p>

        </div>

    </div>

</div>

</body>
</html>