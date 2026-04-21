<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Add New Product</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<style>
    body {
        font-family: 'Poppins', sans-serif;
        background-color: #f0f2f5;
    }
    .add-product-card {
        background: #ffffff;
        border-radius: 15px;
        border: none;
        box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        padding: 40px;
    }
    .form-label {
        font-weight: 600;
        color: #444;
        font-size: 0.9rem;
    }
    .form-control {
        border-radius: 8px;
        padding: 10px 15px;
        border: 1px solid #ddd;
    }
    .form-control:focus {
        border-color: #ff9f43;
        box-shadow: 0 0 8px rgba(255, 159, 67, 0.2);
    }
    .section-title {
        border-bottom: 2px solid #ff9f43;
        display: inline-block;
        margin-bottom: 25px;
        padding-bottom: 5px;
        font-weight: 700;
        color: #2c3e50;
    }
    .btn-submit {
        background: #2c3e50;
        color: white;
        font-weight: 600;
        padding: 12px 30px;
        border-radius: 8px;
        width: 100%;
        transition: 0.3s;
    }
    .btn-submit:hover {
        background: #ff9f43;
        color: white;
        transform: translateY(-2px);
    }
</style>
</head>
<body>

    <%@include file="mainLayout.jsp" %>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10">
                <div class="add-product-card">
                    <h2 class="section-title"><i class="fa-solid fa-plus-circle me-2"></i>Add New Product</h2>
                    
                    <form action="Add-Products" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label class="form-label">Product Title</label>
                                <input type="text" name="title" class="form-control" placeholder="e.g. iPhone 15 Pro Max" required>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Category</label>
                                <select name="category" class="form-select form-control" required>
                                    <option value="">Select Category</option>
                                    <option value="Electronics">Electronics</option>
                                    <option value="Fashion">Fashion</option>
                                    <option value="Home">Home Decor</option>

                                    <option value="Beauty">Beauty&Health</option>
                                    <option value="Leptops"> Leptop</option>
                                    <option value="Mobails">Mobile</option>
                                    <option value="Sports">Sports</option>
                                    
                                </select>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Brand Name</label>
                                <input type="text" name="brand" class="form-control" placeholder="e.g. Apple" required>
                            </div>

                            <div class="col-md-4 mb-3">
                                <label class="form-label">Original Price ($)</label>
                                <input type="number" name="price" class="form-control" placeholder="0.00" required>
                            </div>

                            <div class="col-md-4 mb-3">
                                <label class="form-label">Discount Price (Optional)</label>
                                <input type="number" name="discountPrice" class="form-control" placeholder="0.00">
                            </div>

                            <div class="col-md-4 mb-3">
                                <label class="form-label">Stock Quantity</label>
                                <input type="number" name="stock" class="form-control" placeholder="e.g. 50" required>
                            </div>

                            <div class="col-md-12 mb-3">
                                <label class="form-label">Product Description</label>
                                <textarea name="description" class="form-control" rows="3" placeholder="Write something about product..."></textarea>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Rating (1 to 5)</label>
                                <input type="number" name="rating" step="0.1" max="5" min="1" class="form-control" placeholder="e.g. 4.5">
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Product Image</label>
                                <input type="file" name="img" class="form-control" accept="image/*" requied>
                            </div>

                            <input type="hidden" name="dateAdded" value="<%= new java.util.Date() %>">

                            <div class="col-12 mt-4">
                                <button type="submit" class="btn btn-submit">
                                    <i class="fa-solid fa-cloud-arrow-up me-2"></i>Publish Product
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>