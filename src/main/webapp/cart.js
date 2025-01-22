$("#AddCart").click(function (){

  var ItemPrice = $("#ItemPrice").text();
  var OrderQuantity = $("#Quantity").val();
  var totalPrice = ItemPrice * OrderQuantity;
  var productId = $("#productId").text();
  var userid = $("#user").val();

  console.log("Product ID:", productId);

  $.ajax({
      url:"http://localhost:8080/ASSIGNMENT_JSP_war_exploded/cart",
      method:"POST",
      data:{
          ItemPrice:ItemPrice,
          OrderQuantity:OrderQuantity,
          totalPrice:totalPrice,
          productId:productId,
          userid:userid
      },
      success:(res) =>{
          console.log(res)
      },
      error:(error)=>{
          console.error(error)
      }

  })


})