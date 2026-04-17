<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Password</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.card-box {
    border-radius: 12px;
}
</style>

</head>
<body class="bg-light">

<div class="container">
    <div class="row justify-content-center align-items-center" style="height: 100vh;">
        
        <div class="col-md-5">
            <div class="card shadow card-box p-4">

                <h3 class="text-center mb-3">Update Password</h3>

                <!-- Timer -->
                <p id="timer" class="text-danger fw-bold text-center"></p>

                <form action="updatePasswordUsingOtp" method="post">

                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter email" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">OTP</label>
                        <input type="text" name="otp" class="form-control" placeholder="Enter OTP" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">New Password</label>
                        <input type="password" name="password" minlength="4" maxlength="4"
                               class="form-control"
                               placeholder="Enter 4-digit password" required>
                    </div>

                    <div class="d-grid mb-2">
                        <button id="submitBtn" type="submit" class="btn btn-primary">
                            Update Password
                        </button>
                    </div>

                </form>

                <!-- Action Buttons -->
                <div class="d-flex justify-content-between mt-3">

                    <a href="forget" class="btn btn-outline-warning btn-sm">
                        Resend OTP
                    </a>

                    <a href="Signup" class="btn btn-outline-secondary btn-sm">
                        Signup
                    </a>

                </div>

            </div>
        </div>

    </div>
</div>

<script>
let time = 30;

let timer = setInterval(function(){

    document.getElementById("timer").innerText =
        "OTP expires in " + time + " sec";

    time--;

    if(time < 0){
        clearInterval(timer);

        document.getElementById("timer").innerText = "OTP Expired ⏳";

        // Disable only submit button
        document.getElementById("submitBtn").disabled = true;
    }

}, 1000);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>