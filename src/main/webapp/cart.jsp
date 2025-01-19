<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/15/2025
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart management</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container my-5">
  <div class="card shadow-lg">
    <div class="card-header bg-success text-white text-center">
      <h4 class="mb-0">Shopping Cart</h4>
    </div>
    <div class="card-body">
      <!-- Cart Table -->
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <thead class="table-light">
          <tr>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total</th>
            <th scope="col">Action</th>
          </tr>
          </thead>
          <tbody id="cartItems">
          <!-- Example Cart Item -->
          <tr>
            <td>Product Name</td>
            <td>$25.00</td>
            <td>
              <input type="number" class="form-control" value="1" min="1" max="10" id="quantity1">
            </td>
            <td>$25.00</td>
            <td>
              <button type="button" class="btn btn-danger btn-sm" id="removeItem1">Remove</button>
            </td>
          </tr>
          <!-- More items can be added dynamically -->
          </tbody>
        </table>
      </div>

      <!-- Cart Summary -->
      <div class="d-flex justify-content-between">
        <h5>Total: $25.00</h5>
        <button class="btn btn-primary" id="checkoutBtn">Proceed to Checkout</button>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
