package org.example.assignment_jsp.placeOrder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CartBo;
import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.PlaceOrder;
import org.example.assignment_jsp.Entity.PlaceOrderDto;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/placeorder/*")
public class PlaceOrderServelet extends HttpServlet {

    PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoType.PLACEORDER);

    CartBo cartBo = (CartBo) BoFactory.getBoFactory().getBo(BoType.CART);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String cartId = req.getParameter("cartId");
        String itemPrice = req.getParameter("itemPrice");
        String orderedQuantity = req.getParameter("orderedQuantity");
        String totalPrice = req.getParameter("totalPrice");
        String productId = req.getParameter("productId");
        String userId = req.getParameter("userId");
        String paymentMethod = req.getParameter("paymentMethod");
        String orderDateStr = req.getParameter("orderDate");

        // Parse the received String into LocalDateTime
        LocalDateTime orderDate = null;
        if (orderDateStr != null && !orderDateStr.isEmpty()) {
            try {
                if (orderDateStr.endsWith("Z")) {
                    orderDate = LocalDateTime.ofInstant(
                            java.time.Instant.parse(orderDateStr),
                            java.time.ZoneId.systemDefault()
                    );
                } else {
                    orderDate = LocalDateTime.parse(orderDateStr);
                }
            } catch (Exception e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{\"message\": \"Invalid orderDate format. Expected ISO 8601.\"}");
                return;
            }
        }

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {


            // Fetch product and user entities
            Products product = session.get(Products.class, productId); // productId is now String
            User user = session.get(User.class, Integer.parseInt(userId));

            if (product == null || user == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{\"message\": \"Invalid Product or User ID.\"}");
                return;
            }

            PlaceOrder placeOrder = new PlaceOrder();
            placeOrder.setOrderDate(orderDate);
            placeOrder.setStatus("Pending");
            placeOrder.setItemPrice(itemPrice); // Now String
            placeOrder.setOrderedQuantity(orderedQuantity); // Now String
            placeOrder.setTotalPrice(totalPrice); // Now String
            placeOrder.setPaymentMethod(paymentMethod);
            placeOrder.setProduct(product);
            placeOrder.setUser(user);

            PlaceOrderDto placeOrderDto = new PlaceOrderDto(placeOrder.getOrderId(), placeOrder.getOrderDate(), placeOrder.getOrderedQuantity(), placeOrder.getItemPrice(), placeOrder.getStatus(), placeOrder.getTotalPrice(), placeOrder.getPaymentMethod(), placeOrder.getProduct(), placeOrder.getUser());


            boolean b = placeOrderBo.saveOrder(placeOrderDto);



            if (b){
                boolean b1 = cartBo.deleteCart(cartId);
                System.out.println(" cart deleted : "+ b1);

            }


            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("{\"message\": \"Order placed successfully!\"}");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"message\": \"Failed to place order: " + e.getMessage() + "\"}");
        } finally {
            session.close();
        }
    }
}
