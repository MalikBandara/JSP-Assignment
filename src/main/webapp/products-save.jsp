<%--
  Created by IntelliJ IDEA.
  User: Win10-LL
  Date: 1/20/2025
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>prs</title>
</head>
<body>
<form action="products-save" method="post">

    <label for="id">id:</label><br>
    <input type="text" id="id" name="id"><br><br>

    <label for="name">name:</label><br>
    <input type="text" id="name" name="name"> <br><br>

    <label for="price">price:</label><br>
    <input type="text" id="price" name="price"><br><br>

    <label for="qty">qty:</label><br>
    <input type="text" id="qry" name="qty"><br><br>

    <input type="file" id="productImage" accept="image/*" required>
    <input type="hidden" id="imageHiddenField" name="productImage">

    <button type="submit">save prd</button>
</form>



</body>
</html>
