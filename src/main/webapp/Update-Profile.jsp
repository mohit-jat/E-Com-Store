<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.USER" %>
<%

USER u = (USER) session.getAttribute("user");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background: linear-gradient(135deg, #667eea, #764ba2);
}

.form-card{
    background: white;
    border-radius: 20px;
    padding: 30px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
}

.title{
    font-weight: bold;
    font-size: 24px;
}

.form-control{
    border-radius: 10px;
    padding: 10px;
}

.btn-custom{
    border-radius: 30px;
    font-weight: 600;
}

.form-label{
    font-weight: 600;
    color: #555;
}

</style>

</head>

<body>

<div class="container d-flex justify-content-center align-items-center vh-100">

    <div class="col-md-6">

        <div class="form-card">

            <div class="text-center mb-4">
                <div style="font-size:50px;">✏️</div>
                <div class="title">Edit Profile</div>
                <small class="text-muted">Update your details</small>
            </div>

            <form action="UpdateProfile" method="post">

                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="name" class="form-control"
                           value="<%=u.getName()%>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control"
                           value="<%=u.getEmail()%>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="text" name="phone" class="form-control"
                           value="<%=u.getPhone()%>" required>
                </div>

                <!-- ADDRESS -->
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <textarea name="address" class="form-control" rows="3" required><%=u.getAddress()%></textarea>
                </div>

                <div class="d-flex justify-content-between">

                    <a href="Profile" class="btn btn-secondary btn-custom px-4">
                        Cancel
                    </a>

                    <button type="submit" class="btn btn-primary btn-custom px-4">
                        Update
                    </button>

                </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>