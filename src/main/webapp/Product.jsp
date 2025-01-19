<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>

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

            <a href="">
                <li class="nav-item me-5">
                    <img src="./icons/icons8-cart-50%20(1).png" alt="cart icon" class="img-fluid" style="width: 40px; height: 40px;">
                </li>
            </a>

            <a href="Registration.jsp">
                <li class="nav-item me-5">
                    <img src="./icons/icons8-user-50%20(1).png" alt="user icon" class="img-fluid" style="width: 40px; height: 40px;">
                </li>
            </a>

        </div>
    </ul>
</section>

<div class="d-flex align-items-center justify-content-center vh-100">
    <div class="col-md-8 col-lg-6 mb-5" style="max-width: 900px;">
        <div class="card shadow-lg">
            <div class="card-header text-white" style="background-color: #4b0560">
                <h4 class="mb-0 text-center">Product Management</h4>
            </div>
            <div class="card-body">
                <form>
                    <!-- Product ID Input -->
                    <div class="mb-3">
                        <label for="productId" class="form-label">Product ID</label>
                        <input type="text" class="form-control" id="productId" placeholder="Enter product ID" readonly>
                    </div>

                    <!-- Product Name Input -->
                    <div class="mb-3">
                        <label for="productName" class="form-label">Product Name</label>
                        <input type="text" class="form-control" id="productName" placeholder="Enter product name">
                    </div>

                    <!-- Category Dropdown -->
                    <div class="mb-3">
                        <label for="categoryId" class="form-label">Category</label>
                        <select class="form-select" id="categoryId" aria-label="Category Selection">
                            <option selected disabled>Choose category</option>
                            <option value="1">Electronics</option>
                            <option value="2">Furniture</option>
                            <option value="3">Clothing</option>
                            <option value="4">Accessories</option>
                        </select>
                    </div>

                    <!-- Price Input -->
                    <div class="mb-3">
                        <label for="price" class="form-label">Price</label>
                        <input type="number" class="form-control" id="price" placeholder="Enter price" step="0.01">
                    </div>

                    <!-- Stock Quantity Input -->
                    <div class="mb-3">
                        <label for="stockQuantity" class="form-label">Stock Quantity</label>
                        <input type="number" class="form-control" id="stockQuantity" placeholder="Enter stock quantity">
                    </div>

                    <!-- Description Input -->
                    <div class="mb-3">
                        <label for="description" class="form-label">Description</label>
                        <textarea class="form-control" id="description" placeholder="Enter product description" rows="3"></textarea>
                    </div>

                    <!-- Image URL Input -->
                    <div class="mb-3">
                        <label for="imageUrl" class="form-label">Image URL</label>
                        <input type="url" class="form-control" id="imageUrl" placeholder="Enter image URL">
                    </div>
                </form>
            </div>

            <!-- Action Buttons -->
            <div class="card-footer text-center">
                <button type="button" class="btn btn-primary me-2">Add</button>
                <button type="button" class="btn btn-warning me-2">Update</button>
                <button type="button" class="btn btn-danger me-2">Delete</button>
                <button type="button" class="btn btn-info">View All</button>
            </div>
        </div>
    </div>
</div>







<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
