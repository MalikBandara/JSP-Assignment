<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Browsing</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<section class="nav-bar-cell1-rev " style="background-color: #4b0560">
    <ul class="nav d-flex align-items-center">
        <!-- Left-aligned Item -->

        <a href="index.jsp">
            <li class="nav-item ms-5">
                <img src="./icons/5319210-removebg-preview.png" alt="user icon" class="img-fluid" style="width: 130px; height: 130px;">
            </li>
        </a>


        <!-- Right-aligned Items -->
        <div class="d-flex ms-auto">

            <a href="product_list.jsp">
                <li class="nav-item me-5">
                    <img src="./icons/icons8-products-50.png" alt="products icon" class="img-fluid" style="width: 40px; height: 40px;">
                </li>
            </a>

            <a href=ProductBrowsing.jsp>
                <li class="nav-item me-5">
                    <img src="./icons/icons8-cart-50%20(1).png" alt="cart icon" class="img-fluid" style="width: 40px; height: 40px;">
                </li>
            </a>

            <a href="Login.jsp">
                <li class="nav-item me-5">
                    <img src="./icons/icons8-user-50%20(1).png" alt="user icon" class="img-fluid" style="width: 40px; height: 40px;">
                </li>
            </a>

        </div>
    </ul>
</section>

<div class="container my-5">
    <div class="card shadow-lg">
        <div class="card-header  text-white text-center" style="background-color: #4b0560">
            <h4 class="mb-0">Product Browsing</h4>
        </div>
        <div class="card-body">
            <!-- Filters and Search -->
            <div class="row mb-4">
                <!-- Category Filter -->
                <div class="col-md-4">
                    <label for="categoryFilter" class="form-label">Filter by Category</label>
                    <select class="form-select" id="categoryFilter" aria-label="Category Filter">
                        <option selected value="">All Categories</option>
                        <option value="1">Electronics</option>
                        <option value="2">Furniture</option>
                        <option value="3">Clothing</option>
                        <option value="4">Accessories</option>
                    </select>
                </div>

                <!-- Search by Name -->
                <div class="col-md-4">
                    <label for="searchProduct" class="form-label">Search by Name</label>
                    <input type="text" id="searchProduct" class="form-control" placeholder="Enter product name">
                </div>

                <!-- Sort by Price -->
                <div class="col-md-4">
                    <label for="sortPrice" class="form-label">Sort by Price</label>
                    <select class="form-select" id="sortPrice" aria-label="Sort by Price">
                        <option selected value="">Sort Options</option>
                        <option value="asc">Price: Low to High</option>
                        <option value="desc">Price: High to Low</option>
                    </select>
                </div>
            </div>

            <!-- Product List -->
            <div class="row" id="productList">
                <!-- Example Product Card -->
                <div class="col-md-4 mb-4">
                    <div class="card shadow-sm">
                        <img src="https://via.placeholder.com/150" class="card-img-top" alt="Product Image">
                        <div class="card-body">
                            <h5 class="card-title">Product Name</h5>
                            <p class="card-text text-muted">$50.00</p>
                            <button class="btn btn-primary btn-sm">View Details</button>
                        </div>
                    </div>
                </div>
                <!-- Repeat Product Cards as Needed -->
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
