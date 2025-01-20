<%@ page import="org.example.assignment_jsp.dto.ProductsDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Products</title>
</head>
<body>

<%
    // Retrieve the list of products from the request attribute
    List<ProductsDto> products = (List<ProductsDto>) request.getAttribute("products");

    // Check if the product list is not null and not empty
    if (products != null && !products.isEmpty()) {
%>

<%
    System.out.println("Products list size: " + products.size());
%>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Iterate over the products list and render table rows
        for (ProductsDto productsDto : products) {
    %>
    <tr>
        <td><%= productsDto.getPid() %></td>
        <td><%= productsDto.getName() %></td>
        <td><%= productsDto.getPrice() %></td>
        <td><%= productsDto.getQty() %></td>
        <td><img src="<%= productsDto.getImage() %>" alt="Product Image" width="100" /></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<p>No products found.</p>
<%
    }
%>
</body>
</html>
