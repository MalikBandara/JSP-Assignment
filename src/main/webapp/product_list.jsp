<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/14/2025
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-4">
    <!-- Page Header -->
    <h1 class="text-center mb-4">Product List</h1>

    <!-- Filter and Search Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <!-- Filter Dropdown -->
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" id="categoryDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                Filter by Category
            </button>
            <ul class="dropdown-menu" aria-labelledby="categoryDropdown">
                <li><a class="dropdown-item" href="#">Electronics</a></li>
                <li><a class="dropdown-item" href="#">Clothing</a></li>
                <li><a class="dropdown-item" href="#">Home Appliances</a></li>
            </ul>
        </div>

        <!-- Search Bar -->
        <div class="input-group" style="width: 300px;">
            <input type="text" class="form-control" placeholder="Search products..." aria-label="Search">
            <button class="btn btn-outline-secondary" type="button">Search</button>
        </div>
    </div>

    <!-- Product Grid -->
    <div class="row">
        <!-- Product Card Template -->
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <img src="https://via.placeholder.com/150" class="card-img-top" alt="Product Image">
                <div class="card-body">
                    <h5 class="card-title">Product Name</h5>
                    <p class="card-text">$99.99</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-primary">Add to Cart</button>
                        <button class="btn btn-outline-secondary">View Details</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Repeat product cards for additional products -->
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
