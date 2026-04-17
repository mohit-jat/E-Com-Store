<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Com | Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html, body { 
            height: 100%; 
            margin: 0; 
            overflow-y: auto; 
            background-color: #f4f7f6; 
            font-family: 'Segoe UI', sans-serif; 
        }
        .main-wrapper { 
            display: flex; 
            align-items: center; 
            justify-content: center; 
            min-height: 100vh; 
            padding: 20px 0;
        }
        .signup-card { 
            width: 100%; 
            max-width: 450px; 
            background: white; 
            padding: 2rem; 
            border-radius: 15px; 
            box-shadow: 0 10px 25px rgba(0,0,0,0.1); 
        }
        .brand-name { font-weight: 700; color: #0d6efd; }
    </style>
</head>
<body>

    <div class="main-wrapper">
        <div class="signup-card text-center">
            <h2 class="brand-name">Glis-</h2>
            <p class="text-muted mb-4">Create HR Account</p>

            <form action="Signup" method="post">
                <div class="form-floating mb-3">
                    <input type="text" name="name" class="form-control" id="n" placeholder="Name" required>
                    <label for="n">Full Name</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" name="username" class="form-control" id="u" placeholder="User" required>
                    <label for="u">Username</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="email" name="email" class="form-control" id="e" placeholder="Email" required>
                    <label for="e">Email Address</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="tel" name="phone" class="form-control" id="c" 
                           placeholder="Contact" required 
                           pattern="[0-9]{10}" 
                           maxlength="10" 
                           title="Please enter a valid 10-digit phone number">
                    <label for="c">Contact Number</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" name="address" class="form-control" id="a" placeholder="Address" required>
                    <label for="a">Full Address</label>
                </div>

                <div class="form-floating mb-4">
                    <input type="password" name="password" class="form-control" id="p" 
                           placeholder="Pass" required 
                           pattern=".{4,4}" 
                           maxlength="4"
                           title="Password exactly 4 characters ka hona chahiye!">
                    <label for="p">Password (4 Digits)</label>
                </div>

                <button type="submit" class="btn btn-primary w-100 py-2 fw-bold">Register Now</button>
            </form>

            <div class="mt-4">
                <a href="Login" class="text-decoration-none small fw-bold">Already have an account? Login</a>
            </div>
        </div>
    </div>

</body>
</html>