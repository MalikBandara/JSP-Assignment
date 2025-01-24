package org.example.assignment_jsp.servelet.Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CartBo;
import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.Cart;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.dto.CartDto;
import org.example.assignment_jsp.dto.ProductsDto;
import org.example.assignment_jsp.dto.UserDto;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/cart/*")
public class CartServlet extends HttpServlet {


    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoType.USER);

    CartBo cartBo = (CartBo) BoFactory.getBoFactory().getBo(BoType.CART);





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String itemPrice = req.getParameter("ItemPrice");
            String orderQuantity = req.getParameter("OrderQuantity");
            String totalPrice = req.getParameter("totalPrice");
            String id = req.getParameter("productId");
            String userid = req.getParameter("userid");


            System.out.println( "look "  + id);

            ProductsDto productId = productsBo.getProductId(id);

            Products products = new Products(productId.getPid(), productId.getName(), productId.getQty(), productId.getPrice(), productId.getImage(), productId.getCategory());

            UserDto userId = userBo.getUserId(userid);

            User user = new User(userId.getUserId(), userId.getUserName(), userId.getEmail(), userId.getPassword(), userId.isActive(), userId.getRole(), userId.getCreatedAt());

            Cart cart = new Cart(0, products, user, itemPrice, orderQuantity, totalPrice);

            CartDto cartDto = new CartDto(cart.getCartId(),cart.getProduct(),cart.getUser(),cart.getItemPrice(),cart.getOrderedQuantity(),cart.getTotalPrice());

            ProductsDto productsDto = new ProductsDto(products.getPid(), products.getName(), products.getQty(), products.getPrice(), products.getImage(), products.getCategory());

            cartBo.saveCart(cartDto);

            String productQty = products.getQty();
            System.out.println(productQty);

            int orderQty = Integer.parseInt(orderQuantity);
            int oldQty = Integer.parseInt(productQty);

            if (oldQty >= orderQty) {

                int updatedQuantity = oldQty - orderQty;
                productsDto.setQty(String.valueOf(updatedQuantity));  // Set the updated quantity
                productsBo.updateProducts(productsDto);
                System.out.println("Product quantity updated successfully.");
            } else {
                System.out.println("Insufficient stock available.");
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
