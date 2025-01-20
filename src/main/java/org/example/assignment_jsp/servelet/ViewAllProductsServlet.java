package org.example.assignment_jsp.servelet;

import jakarta.servlet.RequestDispatcher;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="ViewAllProductsServlet" , value ="/products-all")

public class ViewAllProductsServlet extends HttpServlet {

    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Use ProductsBo to get the DTO list
        List<ProductsDto> allProducts = productsBo.getAllProducts();

        System.out.println("Retrieved Products: ");
        for (ProductsDto product : allProducts) {
            System.out.println("ID: " + product.getPid() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice() +
                    ", Quantity: " + product.getQty() +
                    ", Image: " + product.getImage());
        }


        // Set the DTO list as a request attribute
        req.setAttribute("products", allProducts);

        // Forward the request to the JSP page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("products-all.jsp");
        requestDispatcher.forward(req, resp);

    }
}
