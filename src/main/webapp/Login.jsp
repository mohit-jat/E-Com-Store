<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Com | Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            background-color: #f4f7f6;
        }
        
        .main-wrapper {
            display: flex;
            align-items: center; 
            justify-content: center; 
            min-height: 100vh; 
            padding: 20px;
        }

        .login-card {
            width: 100%;
            max-width: 400px; 
            background: white;
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>

    <div class="main-wrapper">
        <div class="login-card">
            <div class="text-center mb-4">
                <h2 class="fw-bold text-primary">E-Com</h2>
                <p class="text-muted small">Login to your account</p>
            </div>

            <form action="Login" method="post">
                <div class="form-floating mb-3">
                    <input type="text" name="username" class="form-control" id="uName" placeholder="Username" required>
                    <label for="uName">Username</label>
                </div>
                
                <div class="form-floating mb-4">
                    <input type="password" name="password" class="form-control" id="uPass" placeholder="Password" required>
                    <label for="uPass">Password</label>
                </div>


                <button type="submit" class="btn btn-primary w-100 py-2 fw-bold">Login</button>
            </form>
<div class="text-end mb-3">
    <a href="forget" class="text-decoration-none small text-primary fw-semibold">
        Forgot Password?
    </a>
</div>
            <div class="text-center mt-4">
                <p class="mb-0 text-muted small">Don't have an account? <a href=Signup class="text-primary text-decoration-none fw-bold">Sign Up</a></p>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>