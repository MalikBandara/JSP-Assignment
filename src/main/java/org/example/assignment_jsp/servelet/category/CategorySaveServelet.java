package org.example.assignment_jsp.servelet.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.example.assignment_jsp.dto.CategoryDto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Timestamp;


@WebServlet(name = "CategorySaveServelet" , value = "/category-save")

public class CategorySaveServelet extends HttpServlet {


    CategoryBo categoryBo = (CategoryBo) BoFactory.getBoFactory().getBo(BoType.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

//        Category category = new Category(id, name, createdAt);
//        Session session = SessionFactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(category);
//        transaction.commit();

        CategoryDto categoryDto = new CategoryDto(id,name,createdAt);

        categoryBo.saveCategory(categoryDto);

    }
}
