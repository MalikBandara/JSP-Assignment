package org.example.assignment_jsp.servelet.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;


@WebServlet(name =  "ProductsDeleteServelet" , value = "/products-delete")
public class ProductsDeleteServelet extends HttpServlet {

    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");

        boolean b = productsBo.deleteProducts(id);

        if (b) {
            req.getSession().setAttribute("registrationStatus", "success");
            resp.sendRedirect("products-delete.jsp");
        } else {
            req.getSession().setAttribute("registrationStatus", "error");
            resp.sendRedirect("AdminDash");
        }


    }
}
