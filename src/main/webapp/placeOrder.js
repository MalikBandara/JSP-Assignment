$(document).ready(function () {
    $(".placeOrder").click(function () {
        // Fill modal inputs with data attributes from the button
        $("#modalCartId").val($(this).data("cart-id"));
        $("#modalItemPrice").val($(this).data("item-price"));
        $("#modalOrderedQuantity").val($(this).data("ordered-quantity"));
        $("#modalTotalPrice").val($(this).data("total-price"));
        $("#modalProductId").val($(this).data("product-id"));
        $("#modalUserId").val($(this).data("user-id"));
    });

    $("#confirmPayment").click(function () {
        // Collect form data
        var paymentMethod = $("#paymentMethod").val();
        var cartId = $("#modalCartId").val();
        var itemPrice = $("#modalItemPrice").val();
        var orderedQuantity = $("#modalOrderedQuantity").val();
        var totalPrice = $("#modalTotalPrice").val();
        var productId = $("#modalProductId").val();
        var userId = $("#modalUserId").val();

        // Get the current local date and time
        var orderDate = new Date().toISOString();

        // Send order data to the backend
        $.ajax({
            url: "http://localhost:8082/ASSIGNMENT_JSP_war/placeorder",
            method: "POST",
            data: {
                cartId: cartId,
                itemPrice: itemPrice,
                orderedQuantity: orderedQuantity,
                totalPrice: totalPrice,
                productId: productId,
                userId: userId,
                paymentMethod: paymentMethod,
                orderDate: orderDate, // Add the order date
            },
            success: function (res) {
                alert("Order placed successfully!");
                $("#paymentModal").modal("hide");
            },
            error: function () {
                alert("Failed to place order!");
            },
        });
    });
});
