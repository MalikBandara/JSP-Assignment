package org.example.assignment_jsp.servelet.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.dto.UserDto;

import java.io.IOException;
import java.sql.Timestamp;


@WebServlet(name = "UserServlet" , value = "/Registration")
public class UserRegistrationServlet extends HttpServlet {

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoType.USER);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password"); // Consider hashing the password
            String role = req.getParameter("role");
            boolean isActive = true; // Default active status
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());

            UserDto user = new UserDto(0, username, email, password, isActive, role, createdAt);

            boolean b = userBo.SaveUsers(user);

            if (b) {
                req.getSession().setAttribute("registrationStatus", "success");
                resp.sendRedirect("Registration.jsp");
            } else {
                req.getSession().setAttribute("registrationStatus", "error");
                resp.sendRedirect("Registration.jsp");
            }


        }catch (Exception e ){
            e.printStackTrace();
            req.setAttribute("registrationStatus", "error");
        }

    }
}
