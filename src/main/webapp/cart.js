$(".AddCart").click(function () {
    // Retrieve data from the clicked button
    var itemPrice = $(this).data('item-price');
    var productId = $(this).data('product-id');
    var quantityAvailable = $(this).data('quantity-available');
    var orderQuantity = $(this).closest('.product-card').find('.Quantity').val();
    var userId = $(this).closest('.product-card').find('.user').val();

    var totalPrice = itemPrice * orderQuantity;

    console.log("Item Price:", itemPrice);
    console.log("Order Quantity:", orderQuantity);
    console.log("User ID:", userId);
    console.log("Total Price:", totalPrice);
    console.log("Product ID:", productId);

    $.ajax({
        url: "http://localhost:8080/ASSIGNMENT_JSP_war_exploded/cart",
        method: "POST",
        data: {
            ItemPrice: itemPrice,
            OrderQuantity: orderQuantity,
            totalPrice: totalPrice,
            productId: productId,
            userid: userId
        },
        success: (res) => {
            console.log(res);
        },
        error: (error) => {
            console.error(error);
        }
    });
});
