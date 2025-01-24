<%@ page import="org.example.assignment_jsp.dto.CategoryDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.assignment_jsp.Entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/20/2025
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Save Page</title>
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

<div class="row align-items-center py-3 px-xl-5">
    <div class="col-lg-3 d-none d-lg-block">
        <a href="AdminDash.jsp" class="text-decoration-none">
            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Admin</span>Page</h1>
        </a>
    </div>

</div>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8 col-sm-10">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4">Save Product</h3>
                <form action="products-save" method="post" enctype="multipart/form-data">

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
                        <label for="qry" class="form-label">Quantity</label>
                        <input type="text" id="qry"  class="form-control" name="qty">
                    </div>

                    <div class="mb-3">
                        <label for="category" class="form-label">Category</label>
                        <select id="category" name="category" class="form-control">
                            <%
                                List<CategoryDto> categories = (List<CategoryDto>) request.getAttribute("categories");
                                if (categories != null && !categories.isEmpty()) {
                                    for (CategoryDto category : categories) {
                            %>
                            <option value="<%= category.getCid() %>"><%= category.getCname() %></option>
                            <%
                                }
                            } else {
                            %>
                            <option disabled>No categories available</option>
                            <%
                                }
                            %>

                        </select>
                    </div>


                    <div class="mb-3">
                        <label for="image" class="form-label">Image</label>
                        <input type="file" class="form-control" id="image" placeholder="Input image" name="product_img">
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Save Product</button>
                </form>
            </div>

        </div>

    </div>

</div>


<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    <%
    String registrationStatus = (String) session.getAttribute("registrationStatus");
    if ("success".equals(registrationStatus)) {
        session.removeAttribute("registrationStatus"); // Clean up session attribute
%>
    Swal.fire({
        title: 'Product save Successful!',
        text: 'Your Product has been save successfully.',
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
        text: 'An error occurred while saving your product. Please try again.',
        icon: 'error',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <% } %>

</script>

</body>
</html>



