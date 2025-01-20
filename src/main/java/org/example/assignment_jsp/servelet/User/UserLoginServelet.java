package org.example.assignment_jsp.servelet.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;

import java.io.IOException;

@WebServlet(name = "UserLoginServelet" , value = "/Login")
public class UserLoginServelet  extends HttpServlet {

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoType.USER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            System.out.println("Email: " + email + ", Password: " + password); // Debugging line

            // Check if the user is authenticated
            boolean isAuthenticated = userBo.LoginDateails(email, password);

            System.out.println("isAuthenticated: " + isAuthenticated); // Debugging line

            if (isAuthenticated) {
                // Get the role of the user (assuming you have a method in UserBo to get the role)
                String role = userBo.getUserRole(email); // You need to implement this method

                // Create a session and set a user attribute (email or user object)
                HttpSession session = req.getSession();
                session.setAttribute("user", email); // Store the user email or a user object
                session.setAttribute("role", role); // Store the user's role

                // Redirect based on the user's role
                if ("ADMIN".equalsIgnoreCase(role)) {
                    // Redirect to admin dashboard if the role is Admin
                    resp.sendRedirect("AdminDash.jsp");
                } else {
                    // Redirect to customer dashboard if the role is Customer
                    resp.sendRedirect("UserDashBoard.jsp");
                }

            } else {
                // If authentication fails, redirect to login.jsp with error message
                req.setAttribute("error", "Invalid email or password");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            // Log the exception and send an error response
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        }
    }


}

