<%@ page import="org.example.assignment_jsp.dto.ProductsDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product View Page</title>

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Poppins', sans-serif;
        }

        h2 {
            font-weight: bold;
            color: #343a40;
            text-align: center;
            margin-top: 30px;
            margin-bottom: 20px;
        }

        .product-card {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 15px;
            overflow: hidden;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .product-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .product-card img {
            width: 30%;
            height: 350px;
            object-fit: cover;
        }

        .product-info {
            padding: 15px;
        }

        .product-info h5 {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .product-info p {
            font-size: 14px;
            color: #666;
            margin-bottom: 15px;
        }

        .product-info .price {
            font-size: 16px;
            font-weight: bold;
            color: #007bff;
        }

        .product-info .btn-add-to-cart {
            background-color: #28a745;
            color: white;
            font-size: 14px;
            font-weight: bold;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .product-info .btn-add-to-cart:hover {
            background-color: #218838;
        }

        .product-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
    </style>
</head>
<body>

<div class="row align-items-center py-3 px-xl-5">
    <div class="col-lg-3 d-none d-lg-block">
        <a href="UserDashBoard.jsp" class="text-decoration-none">
            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Home</span>Page</h1>
        </a>
    </div>

</div>

<div class="container">
    <h2>Women's Clothing's</h2>



    <%
        // Retrieve the list of products from the request attribute
        List<ProductsDto> products = (List<ProductsDto>) request.getAttribute("products");

        // Check if the product list is not null and not empty
        if (products != null && !products.isEmpty()) {
    %>

    <div class="product-grid">
        <%
            // Iterate over the products list and render product cards
            for (ProductsDto product : products) {
        %>
        <div class="product-card">
            <img src="<%= product.getImage() %>" alt="<%= product.getName() %>">
            <div class="product-info">
                <br>
                <h5>Product ID:</h5>
                <br>
                <h5 class="productId" ><%= product.getPid() %></h5>
                <br>
                <h5><%= product.getName() %></h5>
                <br>
                <h5 style="color: #1c7430">Quantity Available: <%= product.getQty() %></h5>
                <br>
                <div style="display: flex; align-items: center; gap: 10px;">
                    <h5>Product Price:</h5>
                    <h5  class="ItemPrice"><%= product.getPrice() %></h5>
                </div>
                <br>
                <div class="mb-3">
                    <label class="form-label">Quantity ordered</label>
                    <input type="text" class="form-control Quantity"  placeholder="">
                </div>

                <div class="mb-3">
                    <label class="form-label">User id </label>
                    <input type="text" class="form-control user"  placeholder="">
                </div>

                <button type="button" style="background-color: #D19C97; color: black; border: none; padding: 10px 20px; border-radius: 8px; font-size: 16px; cursor: pointer;  transition: background-color 0.3s ease;" class="AddCart"
                        data-product-id="<%= product.getPid() %>"
                        data-item-price="<%= product.getPrice() %>"
                        data-quantity-available="<%= product.getQty() %>">Save Category</button>

            </div>
        </div>

        <% } %>
    </div>

    <% } else { %>
    <div class="alert alert-warning text-center" role="alert">
        No products found.
    </div>
    <% } %>

</div>

<script src="libb/jquery-3.7.1.min.js"></script>
<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script src="cart.js"></script>

<script>
    <%
    String registrationStatus = (String) session.getAttribute("registrationStatus");
    if ("success".equals(registrationStatus)) {
        session.removeAttribute("registrationStatus"); // Clean up session attribute
%>
    Swal.fire({
        title: 'Registration Successful!',
        text: 'Your account has been created successfully.',
        icon: 'success',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <%
        } else if ("error".equals(registrationStatus)) {
            session.removeAttribute("registrationStatus"); // Clean up session attribute
    %>
    Swal.fire({
        title: 'Registration Failed',
        text: 'An error occurred while creating your account. Please try again.',
        icon: 'error',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <% } %>

</script>
</body>
</html>
