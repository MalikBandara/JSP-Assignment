<%@ page import="org.example.assignment_jsp.dto.UserDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/20/2025
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Users</title>

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Styles -->
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
            font-family: 'Poppins', sans-serif;
        }

        .container {
            margin-top: 50px;
        }

        table {
            background-color: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        th, td {
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #007bff; /* Blue header */
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Alternate row color */
        }

        tr:hover {
            background-color: #f1f1f1; /* Hover effect */
        }

        .alert {
            background-color: #dc3545;
            color: white;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div class="row align-items-center py-3 px-xl-5">
    <div class="col-lg-3 d-none d-lg-block">
        <a href="AdminDash.jsp" class="text-decoration-none">
            <h1 class="m-0 display-5 font-weight-semi-bold" style="color: black ;font-weight: bold"><span class=" font-weight-bold border px-3 mr-1" style="color: #b58480 ; font-weight: bold">Admin</span>Page</h1>
        </a>
    </div>

</div>

<div class="container">
    <h3 class="text-center mb-4">Category List</h3>

    <%
        // Retrieve the list of categories from the request attribute
        List<UserDto> user = (List<UserDto>) request.getAttribute("users");

        // Check if the category list is not null and not empty
        if (user != null && !user.isEmpty()) {
    %>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Created At</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Iterate over the categories list and render table rows
            for (UserDto categoryDto : user) {
        %>
        <tr>
            <td><%= categoryDto.getUserId() %></td>
            <td><%= categoryDto.getUserName() %></td>
            <td><%= categoryDto.getEmail() %></td>
            <td><%= categoryDto.getRole() %></td>
            <td><%= categoryDto.getCreatedAt() %></td>
            <td><%= categoryDto.isActive() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <%
    } else {
    %>
    <div class="alert">No categories found.</div>
    <%
        }
    %>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>



</body>
</html>
