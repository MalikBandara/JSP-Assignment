package org.example.assignment_jsp.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Timestamp;


@WebServlet(name = "UserServlet" , value = "/Registration")
public class UserServlet extends HttpServlet {

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

            User user = new User(0, username, email, password, isActive, role, createdAt);

            userBo.SaveUsers(user);

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
