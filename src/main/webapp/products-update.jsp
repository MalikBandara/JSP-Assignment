<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/20/2025
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Update Page</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8 col-sm-10">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4">Update Product</h3>
                <form action="products-update" method="post">

                    <div class="mb-3">
                        <label for="id" class="form-label">Product ID</label>
                        <input type="text" id="id" class="form-control" name="id">
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">Product Name</label>
                        <input type="text" id="name" class="form-control" name="name">
                    </div>
                    <div class="mb-3">
                        <label for="price" class="form-label">Price</label>
                        <input type="text" id="price" class="form-control" name="price">
                    </div>
                    <div class="mb-3">
                        <label for="qty" class="form-label">Quantity</label>
                        <input type="text" id="qry"  class="form-control" name="qty">
                    </div>
                    <div class="mb-3">
                        <label for="productImage" class="form-label">Product Image</label>
                        <input type="file" id="productImage" accept="image/*" required>
                        <input type="hidden" id="imageHiddenField" name="productImage">
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Update Product</button>
                </form>
            </div>

        </div>

    </div>

</div>


<%--<form action="products-update" method="post">--%>

<%--    <label for="id">id:</label><br>--%>
<%--    <input type="text" id="id" name="id"><br><br>--%>

<%--    <label for="name">name:</label><br>--%>
<%--    <input type="text" id="name" name="name"> <br><br>--%>

<%--    <label for="price">price:</label><br>--%>
<%--    <input type="text" id="price" name="price"><br><br>--%>

<%--    <label for="qty">qty:</label><br>--%>
<%--    <input type="text" id="qry" name="qty"><br><br>--%>

<%--    <input type="file" id="productImage" accept="image/*" required>--%>
<%--    <input type="hidden" id="imageHiddenField" name="productImage">--%>

<%--    <button type="submit">save prd</button>--%>
<%--</form>--%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
