package org.example.assignment_jsp.servelet.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.example.assignment_jsp.dto.CategoryDto;
import org.example.assignment_jsp.dto.ProductsDto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@WebServlet(name =  "ProductSaveServvlet" , value = "/products-save")
public class ProductSaveServvlet extends HttpServlet {


    CategoryBo categoryBo = (CategoryBo) BoFactory.getBoFactory().getBo(BoType.CATEGORY);
    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String qty = req.getParameter("qty");
        String imageString = req.getParameter("productImage");
        String category1 = req.getParameter("category");
        byte[] imageBytes = null;

        if (imageString != null && !imageString.isEmpty()) {
            imageBytes = Base64.getDecoder().decode(imageString);
        }


        CategoryDto categoryDto = categoryBo.searchByCategoryId(category1);

        Category category = new Category(categoryDto.getCid(),categoryDto.getCname(),categoryDto.getCreatedAt());

        ProductsDto products = new ProductsDto(id, name, qty, price, imageBytes, category);

        boolean b = productsBo.saveProducts(products);

        if (b) {
//            req.getSession().setAttribute("registrationStatus", "success");
            resp.sendRedirect("products-save.jsp");
        } else {
//            req.getSession().setAttribute("registrationStatus", "error");
            resp.sendRedirect("AdminDash.jsp");
        }


    }
}
