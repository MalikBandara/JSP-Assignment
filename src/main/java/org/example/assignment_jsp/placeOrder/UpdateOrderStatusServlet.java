package org.example.assignment_jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;

import java.io.IOException;

@WebServlet(name = "UpdateOrderStatusServlet", urlPatterns = "/UpdateOrderStatusServlet")
public class UpdateOrderStatusServlet extends HttpServlet {

    PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoType.PLACEORDER);
     // Service layer to handle business logic

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            String orderId = request.getParameter("orderId");
            String newStatus = request.getParameter("newStatus");

            // Validate the inputs
            if (orderId == null || orderId.isEmpty() || newStatus == null || newStatus.isEmpty()) {
                request.setAttribute("error", "Invalid input for updating order status.");
                request.getRequestDispatcher("ProductViewPage.jsp").forward(request, response);
                return;
            }

            // Update the order status using the service layer
            boolean isUpdated = placeOrderBo.updateOrderStatus(orderId, newStatus);

            // Check if the update was successful
            if (isUpdated) {
                request.getSession().setAttribute("registrationStatus", "success");
                response.sendRedirect("ViewPlaceOrders");
            } else {
                request.getSession().setAttribute("registrationStatus", "error");
                response.sendRedirect("ViewPlaceOrders.jsp");
            }

            // Redirect back to the product view page


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An unexpected error occurred: " + e.getMessage());
            request.getRequestDispatcher("ProductViewPage.jsp").forward(request, response);
        }
    }
}
