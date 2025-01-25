<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Update</title>

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
            background-color: #D19C97; /* Soft brownish color */
            font-family: 'Poppins', sans-serif;
            color: #333;
        }

        .card {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h3 {
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            font-weight: 500;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
        }

        input[type="text"]:focus {
            outline-color: #D19C97;
            border-color: #D19C97;
        }

        button {
            background-color: #D19C97;
            color: white;
            font-weight: bold;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            width: 100%;
            cursor: pointer;
        }

        button:hover {
            background-color: #b58480; /* Darker shade on hover */
        }

        .container {
            margin-top: 50px;
        }

        .form-group {
            margin-bottom: 20px;
        }
    </style>
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
                <h3 class="text-center mb-4">Update Category</h3>
                <form action="category-update" method="post">

                    <div class="mb-3 form-group">
                        <label for="id" class="form-label">Category ID</label>
                        <input type="text" id="id" class="form-control" name="id" required>
                    </div>

                    <div class="mb-3 form-group">
                        <label for="name" class="form-label">Category Name</label>
                        <input type="text" id="name" class="form-control" name="name" required>
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Update Category</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    <%
    String registrationStatus = (String) session.getAttribute("registrationStatus");
    if ("success".equals(registrationStatus)) {
        session.removeAttribute("registrationStatus"); // Clean up session attribute
%>
    Swal.fire({
        title: 'category update Successful!',
        text: 'Your category has been update successfully.',
        icon: 'success',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <%
        } else if ("error".equals(registrationStatus)) {
            session.removeAttribute("registrationStatus"); // Clean up session attribute
    %>
    Swal.fire({
        title: 'category update Failed',
        text: 'An error occurred while updating your category. Please try again.',
        icon: 'error',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <% } %>

</script>

</body>
</html>
