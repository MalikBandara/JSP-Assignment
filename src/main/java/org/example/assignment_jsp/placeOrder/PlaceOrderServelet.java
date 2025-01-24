package org.example.assignment_jsp.placeOrder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.Entity.PlaceOrder;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/placeorder/*")
public class PlaceOrderServelet extends HttpServlet {
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
            transaction = session.beginTransaction();

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

            session.save(placeOrder);
            transaction.commit();

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
