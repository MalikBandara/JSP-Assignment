<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Save Category</title>

    <link href="css/style.css" rel="stylesheet">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: white; /* Soft brownish color */
            font-family: 'Poppins', sans-serif;
            color: #333;
        }

        .container {
            background-color: whitesmoke;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin-top: 50px;
        }

        h2 {
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-weight: 500;
            margin-bottom: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        input:focus {
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

        .alert {
            margin-top: 20px;
            text-align: center;
        }
    </style>
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
    <h2>Save Category</h2>

    <form action="category-save" method="post">

        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" required>
        </div>

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>

        <button type="submit" style="background-color:#b58480 ">Save Category</button>
    </form>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    <%
    String registrationStatus = (String) session.getAttribute("registrationStatus");
    if ("success".equals(registrationStatus)) {
        session.removeAttribute("registrationStatus"); // Clean up session attribute
%>
    Swal.fire({
        title: 'category save Successful!',
        text: 'Your category has been save successfully.',
        icon: 'success',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <%
        } else if ("error".equals(registrationStatus)) {
            session.removeAttribute("registrationStatus"); // Clean up session attribute
    %>
    Swal.fire({
        title: 'category save Failed',
        text: 'An error occurred while saving your category. Please try again.',
        icon: 'error',
        confirmButtonText: 'OK',
        confirmButtonColor: '#D19C97'
    });
    <% } %>

</script>
</body>
</html>
