<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Management</title>

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
                <h4 class="mb-0 text-center">Category Management</h4>
            </div>
            <div class="card-body">
                <form>
                    <!-- Category ID Input -->
                    <div class="mb-3">
                        <label for="categoryId" class="form-label">Category ID</label>
                        <input type="text" class="form-control" id="categoryId" placeholder="Enter category ID">
                    </div>

                    <!-- Category Name Input -->
                    <div class="mb-3">
                        <label for="categoryName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="categoryName" placeholder="Enter category name">
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
