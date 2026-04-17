<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.box{
    background:white;
    padding:25px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
}
</style>

</head>

<body>

<div class="container mt-5">

    <h2 class="mb-4">📞 Contact Us</h2>

    <div class="box">

        <form action="Contact" method="post">

            <input type="text" name="name" class="form-control mb-2" placeholder="Your Name" required>

            <input type="email" name="email" class="form-control mb-2" placeholder="Your Email" required>

            <textarea name="message" class="form-control mb-2" placeholder="Your Message" required></textarea>

            <button class="btn btn-success">Send Message</button>

        </form>

        <hr>

        <p>📍 Address: India</p>
        <p>📞 Phone: +91-9999999999</p>
        <p>📧 Email: support@mystore.com</p>

    </div>

</div>

</body>
</html>