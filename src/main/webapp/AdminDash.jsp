<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Link to Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px;
            background: #D19C97;
            font-family: 'Roboto', sans-serif;
        }
        .content-area {
            padding: 30px;
        }
        .dashboard-card {
            border: none;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }
        .dashboard-card-header {
            background-color: #D19C97;
            color: white;
            text-align: center;
            padding: 15px;
            font-size: 20px;
            font-weight: bold;
        }
        .dashboard-card-body {
            padding: 20px;
            background-color: white;
        }
        .btn-block {
            margin-bottom: 10px;
            font-weight: bold;
            text-transform: uppercase;
            transition: transform 0.2s;
            background-color: #D19C97;
            color: white;
            border: none;
        }
        .btn-block:hover {
            transform: scale(1.05);
            background-color: #b58480;
        }
        .navbar {
            background-color: #D19C97;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 24px;
            color: #fff !important;
        }
        .navbar a {
            color: #fff;
            font-size: 18px;
            transition: color 0.3s;
        }
        .navbar a:hover {
            color: #b58480;
        }
    </style>
</head>
<body>

<!-- Admin Dashboard Start -->
<div class="container-fluid">
    <!-- Topbar Start -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">

        <div class="ml-auto">
            <a class="text-light" href="index.jsp">
                <i class="fas fa-sign-out-alt"></i> Logout
            </a>
        </div>
    </nav>
    <!-- Topbar End -->

    <!-- Dashboard Content Start -->
    <div class="content-area">
        <div class="container">
            <div class="row">
                <!-- Product Management Section -->
                <div class="col-md-6 mb-4">
                    <div class="card dashboard-card">
                        <div class="card-header dashboard-card-header">
                            Product Management
                        </div>
                        <div class="card-body dashboard-card-body">
                            <ul class="list-unstyled">
                                <li><a href="products-save.jsp" class="btn btn-block">Add Product</a></li>
                                <li><a href="products-all" class="btn btn-block">View Products</a></li>
                                <li><a href="products-update.jsp" class="btn btn-block">Update Product</a></li>
                                <li><a href="products-delete.jsp" class="btn btn-block btn-danger">Delete Product</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Category Management Section -->
                <div class="col-md-6 mb-4">
                    <div class="card dashboard-card">
                        <div class="card-header dashboard-card-header">
                            Category Management
                        </div>
                        <div class="card-body dashboard-card-body">
                            <ul class="list-unstyled">
                                <li><a href="category-save.jsp" class="btn btn-block">Add Category</a></li>
                                <li><a href="view-all-category" class="btn btn-block">View Categories</a></li>
                                <li><a href="category-update.jsp" class="btn btn-block">Update Category</a></li>
                                <li><a href="category-delete.jsp" class="btn btn-block btn-danger">Delete Category</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Order Management Section -->
                <div class="col-md-6 mb-4">
                    <div class="card dashboard-card">
                        <div class="card-header dashboard-card-header">
                            Order Management
                        </div>
                        <div class="card-body dashboard-card-body">
                            <ul class="list-unstyled">
                                <li><a href="viewOrders.jsp" class="btn btn-block">View Orders</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- User Management Section -->
                <div class="col-md-6 mb-4">
                    <div class="card dashboard-card">
                        <div class="card-header dashboard-card-header">
                            User Management
                        </div>
                        <div class="card-body dashboard-card-body">
                            <ul class="list-unstyled">
                                <li><a href="viewUsers.jsp" class="btn btn-block">View Users</a></li>
                                <li><a href="activateDeactivateUser.jsp" class="btn btn-block">Activate/Deactivate User</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Dashboard Content End -->
</div>
<!-- Admin Dashboard End -->

<!-- Link to Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
