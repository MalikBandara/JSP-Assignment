// $(document).ready(function () {
//     $(".placeOrder").click(function () {
//         // Retrieve data from the button's data-* attributes
//         const cartId = $(this).data("cart-id");
//         const itemPrice = $(this).data("item-price");
//         const orderedQuantity = $(this).data("ordered-quantity");
//         const totalPrice = $(this).data("total-price");
//         const productId = $(this).data("product-id");
//         const userId = $(this).data("user-id");
//
//         // Log the data to confirm it is being retrieved
//         console.log({
//             cartId,
//             itemPrice,
//             orderedQuantity,
//             totalPrice,
//             productId,
//             userId,
//         });
//
//         // AJAX request to send data to the server
//         // $.ajax({
//         //     url: "http://localhost:8082/ASSIGNMENT_JSP_war/", // URL of the servlet
//         //     type: "POST",
//         //     data: {
//         //         cartId: cartId,
//         //         itemPrice: itemPrice,
//         //         orderedQuantity: orderedQuantity,
//         //         totalPrice: totalPrice,
//         //         productId: productId,
//         //         userId: userId,
//         //     },
//         //     success: function (response) {
//         //         // Handle the server's response (optional)
//         //         console.log("Order placed successfully:", response);
//         //         alert("Order placed successfully!");
//         //     },
//         //     error: function (xhr, status, error) {
//         //         // Handle any errors
//         //         console.error("Error placing order:", error);
//         //         alert("Failed to place order. Please try again.");
//         //     },
//         // });
//     });
// });
