package org.example.assignment_jsp.servelet.Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CartBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.dto.CartDto;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewAllCart" , value = "/MyCurt")

public class ViewAllCart extends HttpServlet {

    CartBo cartBo = (CartBo) BoFactory.getBoFactory().getBo(BoType.CART);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartDto> allCart = cartBo.getAllCart();

        req.setAttribute("carts", allCart);

        // Forward the request to the JSP page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("MyCurt.jsp");
        requestDispatcher.forward(req, resp);
    }
}
