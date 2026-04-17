<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help Center</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.help-box{
    background:white;
    border-radius:15px;
    padding:20px;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
}

.faq h5{
    cursor:pointer;
}
</style>

</head>

<body>

<div class="container mt-5">

    <h2 class="mb-4">❓ Help Center</h2>

    <!-- SEARCH HELP -->
    <div class="help-box mb-4">
        <input type="text" class="form-control" placeholder="Search help topics...">
    </div>

    <div class="help-box faq mb-4">

        <h4>🔥 Frequently Asked Questions</h4>

        <hr>

        <h5>1. How to track my order?</h5>
        <p>Go to Track Order section and enter your order ID.</p>

        <h5>2. How to cancel order?</h5>
        <p>You can cancel before shipping from My Orders page.</p>

        <h5>3. How to return product?</h5>
        <p>Click Return/Refund button in Track Order page.</p>

        <h5>4. Payment failed but money deducted?</h5>
        <p>Refund will be automatically processed in 3–5 days.</p>

    </div>

    <!-- CONTACT SUPPORT -->
    <div class="help-box">

        <h4>📞 Contact Support</h4>

        <form action="Help" method="post">

            <input type="text" name="name" class="form-control mb-2" placeholder="Your Name" required>

            <input type="email" name="email" class="form-control mb-2" placeholder="Your Email" required>

            <textarea name="message" class="form-control mb-2" placeholder="Describe your issue" required></textarea>

            <button class="btn btn-primary">Send Message</button>

        </form>

    </div>

</div>

</body>
</html>