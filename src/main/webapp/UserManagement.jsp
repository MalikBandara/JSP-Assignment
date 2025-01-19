<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User management</title>

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

            <a href=UserManagement.jsp>
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
            <h4 class="mb-0">User Management</h4>
        </div>
        <div class="card-body">
            <!-- User Search -->
            <div class="mb-4">
                <form class="d-flex">
                    <input type="text" class="form-control me-2" placeholder="Search by username or email" />
                    <button type="button" class="btn btn-outline-primary">Search</button>
                </form>
            </div>
            <!-- User Table -->
            <div class="table-responsive">
                <table class="table table-striped table-hover shadow-sm rounded bg-white">
                    <thead class="table-primary">
                    <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">Username</th>
                        <th scope="col">Email</th>
                        <th scope="col">Role</th>
                        <th scope="col">Status</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Example Row -->
                    <tr>
                        <td>1</td>
                        <td>john_doe</td>
                        <td>john@example.com</td>
                        <td>CUSTOMER</td>
                        <td><span class="badge bg-success">Active</span></td>
                        <td>
                            <button type="button" class="btn btn-sm btn-warning">Deactivate</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>jane_doe</td>
                        <td>jane@example.com</td>
                        <td>CUSTOMER</td>
                        <td><span class="badge bg-danger">Inactive</span></td>
                        <td>
                            <button type="button" class="btn btn-sm btn-success">Activate</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>admin_user</td>
                        <td>admin@example.com</td>
                        <td>ADMIN</td>
                        <td><span class="badge bg-success">Active</span></td>
                        <td>
                            <button type="button" class="btn btn-sm btn-secondary" disabled>Manage</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
