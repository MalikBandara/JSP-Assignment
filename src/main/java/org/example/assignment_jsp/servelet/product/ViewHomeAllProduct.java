package org.example.assignment_jsp.servelet.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.dto.ProductsDto;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ViewHomeAllProduct" , value = "/WomensProductsHome")

public class ViewHomeAllProduct extends HttpServlet {
    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryId = "2" ; // womens products category ID
        List<ProductsDto> mensT = productsBo.getProductByCategoryId(categoryId);

        System.out.println("Retrieved Products: ");
        for (ProductsDto product : mensT) {
            System.out.println("ID: " + product.getPid() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice() +
                    ", Quantity: " + product.getQty() +
                    ", Image: " + product.getImage());
        }


        // Set the DTO list as a request attribute
        req.setAttribute("products", mensT);

        // Forward the request to the JSP page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WomensProductsHome.jsp");
        requestDispatcher.forward(req, resp);
    }
}
