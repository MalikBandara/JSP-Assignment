<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Register Form</title>
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
        <a href="index.jsp" class="text-decoration-none">
            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
        </a>
    </div>

</div>


<div class="d-flex align-items-center justify-content-center vh-100 pb-5">
    <div class="col-md-8 col-lg-6" style="max-width: 700px;">
        <div class="card shadow">
            <div class="card-header text-white" style="background-color: #D19C97">
                <h3 class="p-3 mb-0 text-center text-light">Registration</h3>
                <p class="text-center p-1 text-light">Your information is protected</p>
            </div>
            <div class="card-body">
                <form action="Registration" method="post">
                    <!-- User Role Selection -->


                    <!-- Username Input -->
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                    </div>

                    <!-- Email Input -->
                    <div class="mb-3">
                        <label for="emailAddress" class="form-label">Email Address</label>
                        <input type="email" class="form-control" id="emailAddress" name="email" placeholder="Enter your email address" required>
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>

                    <!-- Password Input -->
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <div class="input-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Create a password" required>
                            <button class="btn btn-outline-secondary" type="button" id="togglePassword">
                                <i class="bi bi-eye"></i>
                            </button>
                        </div>
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid">
                        <button type="submit" class="btn text-light" style="background-color: #D19C97">Register</button>
                    </div>
                </form>
            </div>
            <div class="card-footer text-muted text-center">
                Already have an account? <a href="Login.jsp" class="text-decoration-none">Log in</a>
            </div>
        </div>
    </div>
</div>

<!-- Toggle Password Visibility Script -->
<script>
    document.getElementById("togglePassword").addEventListener("click", function () {
        const passwordField = document.getElementById("password");
        const passwordFieldType = passwordField.getAttribute("type");
        if (passwordFieldType === "password") {
            passwordField.setAttribute("type", "text");
            this.innerHTML = '<i class="bi bi-eye-slash"></i>';
        } else {
            passwordField.setAttribute("type", "password");
            this.innerHTML = '<i class="bi bi-eye"></i>';
        }
    });
</script>





<!-- Bootstrap Icons CDN -->
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
