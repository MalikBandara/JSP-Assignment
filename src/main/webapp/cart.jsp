<%@ page import="org.example.assignment_jsp.dto.ProductsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.assignment_jsp.dto.CartDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
    <title>Product View Page</title>

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
            font-family: 'Poppins', sans-serif;
        }

        h2 {
            font-weight: bold;
            color: #343a40;
            text-align: center;
            margin-top: 50px;
        }

        .table {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .table-dark {
            background-color: #007bff;
            color: white;
        }

        .table-striped tbody tr:nth-child(odd) {
            background-color: #f1f1f1; /* Light background for odd rows */
        }

        .table-hover tbody tr:hover {
            background-color: #e2e6ea; /* Light hover effect */
        }

        .alert-warning {
            color: #856404;
            background-color: #fff3cd;
            border-color: #ffeeba;
            padding: 15px;
            font-weight: bold;
            text-align: center;
            border-radius: 5px;
        }

        .btn-danger {
            background-color: #dc3545;
            color: white;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }

        .table-responsive {
            max-width: 100%;
            margin: 20px auto;
        }
    </style>

</head>
<body>

<div class="row align-items-center py-3 px-xl-5">
    <div class="col-lg-3 d-none d-lg-block">
        <a href="AdminDash.jsp" class="text-decoration-none">
            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Admin</span>Page</h1>
        </a>
    </div>

</div>

<div class="container">
    <h2 class="mb-4">Cart</h2>

    <%
        // Retrieve the list of products from the request attribute
        List<CartDto> cartDtos = (List<CartDto>) request.getAttribute("carts");

        // Check if the product list is not null and not empty
        if (cartDtos != null && !cartDtos.isEmpty()) {
    %>

    <div class="table-responsive">
        <table class="table table-striped table-hover shadow-sm rounded-3">
            <thead class="table-dark">
            <tr>
                <th scope="col">Cart id</th>
                <th scope="col">item price</th>
                <th scope="col">Ordered quantity</th>
                <th scope="col">Total price</th>
                <th scope="col">Product id</th>
                <th scope="col">user id</th>
                <th scope="col">Action</th> <!-- New column for Place Order -->
            </tr>
            </thead>
            <tbody>
            <%
                // Iterate over the products list and render table rows
                for (CartDto cartDto : cartDtos) {
            %>
            <tr>
                <td><%= cartDto.getCartId() %></td>
                <td><%= cartDto.getItemPrice() %></td>
                <td><%= cartDto.getOrderedQuantity() %></td>
                <td><%= cartDto.getTotalPrice() %></td>
                <td><%= cartDto.getProduct().getPid() %></td>
                <td><%= cartDto.getUser().getUserId() %></td>
                <td>
                    <form action="PlaceOrderServlet" method="post">
                        <!-- Pass the cart ID as a hidden field -->
                        <input type="hidden" name="cartId" value="<%= cartDto.getCartId() %>">
                        <button type="button" class="btn btn-success btn-sm placeOrder">
                            <i class="fas fa-shopping-cart"></i> Place Order
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>


    <% } else { %>
    <div class="alert alert-warning" role="alert">
        No products found.
    </div>
    <% } %>

</div>


<script src="placeOrder.js"></script>

<script src="./libb/jquery-3.7.1.min.js"></script>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
