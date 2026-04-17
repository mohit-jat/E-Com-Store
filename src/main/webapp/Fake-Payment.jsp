<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="mainLayout.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paymetn</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.payment-box {
    margin-top: 80px;
    text-align: center;
}

.loader {
    width: 80px;
    height: 80px;
    border: 8px solid #f3f3f3;
    border-top: 8px solid #0d6efd;
    border-radius: 50%;
    animation: spin 1s linear infinite;
    margin: auto;
}

@keyframes spin {
    100% { transform: rotate(360deg); }
}

.tick {
    font-size: 60px;
    color: green;
    display: none;
}
</style>

</head>
<body>
<div class="container payment-box">

<div class="card shadow-lg p-5 border-0">

<h2 class="text-primary">💳 Processing Payment...</h2>

<p class="text-muted">Please wait while we verify your payment</p>

<div class="loader" id="loader"></div>

<div class="tick" id="tick">✔</div>

<h5 class="mt-3 text-muted" id="msg">
Connecting to bank server...
</h5>

</div>

</div>

<script>
setTimeout(() => {
    document.getElementById("msg").innerText = "Verifying OTP...";
}, 1200);

setTimeout(() => {
    document.getElementById("msg").innerText = "Payment Approved ✔";
    document.getElementById("loader").style.display = "none";
    document.getElementById("tick").style.display = "block";
}, 2500);

setTimeout(() => {
    window.location.href = "PaymentDone";
}, 3500);
</script>	
</body>
</html>
