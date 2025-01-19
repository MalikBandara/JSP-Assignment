<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order History</title>
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

<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="table-responsive" style="max-width: 80%; min-width: 1500px;">
        <table class="table table-striped table-hover shadow-sm rounded-3 bg-white">
            <thead class="table-primary">
            <tr>
                <th scope="col">Order Detail ID</th>
                <th scope="col">Order ID</th>
                <th scope="col">Product ID</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>1001</td>
                <td>501</td>
                <td>2</td>
                <td>500.00</td>
            </tr>
            <tr>
                <td>2</td>
                <td>1002</td>
                <td>502</td>
                <td>3</td>
                <td>1500.00</td>
            </tr>
            <tr>
                <td>3</td>
                <td>1003</td>
                <td>503</td>
                <td>1</td>
                <td>750.00</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
