<%@ page import="model.USER" %>

 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    %>
<%
    USER u = (USER) session.getAttribute("user");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background: #f5f6fa;
}

.profile-header{
    height: 180px;
    background: linear-gradient(135deg, #667eea, #764ba2);
    border-radius: 20px;
}

.profile-card{
    background: white;
    border-radius: 20px;
    margin-top: -80px;
    padding: 30px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.avatar{
    width:100px;
    height:100px;
    border-radius:50%;
    background:white;
    display:flex;
    align-items:center;
    justify-content:center;
    font-size:50px;
    margin:auto;
    margin-top:-50px;
    box-shadow:0 5px 15px rgba(0,0,0,0.2);
}

.name{
    font-size:22px;
    font-weight:bold;
}

.email{
    color:gray;
    font-size:14px;
}

.field-box{
    background: #f8f9ff;
    padding: 12px 15px;
    border-radius: 12px;
    border-left: 4px solid #667eea;
    transition: 0.3s;
}

.field-box:hover{
    background: #eef1ff;
    transform: translateY(-2px);
}

.label{
    font-size: 13px;
    font-weight: 600;
    color: #667eea;
}

.value{
    font-size: 15px;
    font-weight: 500;
    color: #222;
}

.btn-custom{
    border-radius:30px;
    font-weight:600;
}

</style>

</head>

<body>

<div class="container mt-5">

    <div class="profile-header"></div>

    <div class="profile-card text-center">

        <div class="avatar">
            👤
        </div>

        <div class="name mt-3">
            <%= (u!=null)?u.getName():"Guest" %>
        </div>

        <div class="email mb-3">
            <%= (u!=null)?u.getEmail():"Not Logged In" %>
        </div>

        <hr>

        <div class="row text-start mt-4">

            <div class="col-md-6 mb-3">
                <div class="field-box">
                    <div class="label">👤 Username</div>
                    <div class="value">
                        <%= (u!=null)?u.getUsername():"-" %>
                    </div>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <div class="field-box">
                    <div class="label">📞 Phone</div>
                    <div class="value">
                        <%= (u!=null)?u.getPhone():"-" %>
                    </div>
                </div>
            </div>

            <div class="col-md-12 mb-3">
                <div class="field-box">
                    <div class="label">📍 Address</div>
                    <div class="value">
                        <%= (u!=null)?u.getAddress():"-" %>
                    </div>
                </div>
            </div>

        </div>

        <div class="mt-4">

            <a href="UpdateProfile" class="btn btn-primary btn-custom px-4">
                Edit
            </a>

            <a href="DeleteAccount" class="btn btn-danger btn-custom px-4"
               onclick="return confirm('Are you sure?');">
                Delete
            </a>

            <a href="Logout" class="btn btn-dark btn-custom px-4">
                Logout
            </a>

        </div>

    </div>

</div>

</body>
</html>