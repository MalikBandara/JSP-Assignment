package org.example.assignment_jsp.servelet.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.dto.CategoryDto;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ViewAllCategory" , value = "/view-all-category")
public class ViewAllCategory extends HttpServlet {

    CategoryBo categoryBo = (CategoryBo) BoFactory.getBoFactory().getBo(BoType.CATEGORY);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CategoryDto> allCategory = categoryBo.getAllCategory();

        req.setAttribute("category", allCategory);

        // Forward the request to the JSP page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view-all-category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
