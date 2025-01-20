package org.example.assignment_jsp.servelet;

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
import org.example.assignment_jsp.dto.ProductsDto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Base64;


@WebServlet(name =  "ProductSaveServvlet" , value = "/product-save")
public class ProductSaveServvlet extends HttpServlet {

    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String qty = req.getParameter("qty");
        String imageString = req.getParameter("productImage");
        byte[] imageBytes = null;

        if (imageString != null && !imageString.isEmpty()) {
            imageBytes = Base64.getDecoder().decode(imageString);
        }

        ProductsDto products = new ProductsDto(id, name, qty, price, imageBytes);

        boolean b = productsBo.saveProducts(products);

        if (b) {
//            req.getSession().setAttribute("registrationStatus", "success");
            resp.sendRedirect("product-save.jsp");
        } else {
//            req.getSession().setAttribute("registrationStatus", "error");
            resp.sendRedirect("AdminDash.jsp");
        }


    }
}

