package org.example.assignment_jsp.servelet.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.BoLayer.BoFactory;
import org.example.assignment_jsp.BoLayer.BoType;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.dto.CategoryDto;
import org.example.assignment_jsp.dto.ProductsDto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;


@WebServlet(name = "ProductsUpdateServlet" , value = "/products-update")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)

public class ProductsUpdateServlet extends HttpServlet {

    CategoryBo categoryBo = (CategoryBo) BoFactory.getBoFactory().getBo(BoType.CATEGORY);
    ProductsBo productsBo = (ProductsBo) BoFactory.getBoFactory().getBo(BoType.PRODUCT);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryDto> allCategory = categoryBo.getAllCategory();
        System.out.println("update : "+allCategory);

        req.setAttribute("categories" , allCategory);

        req.getRequestDispatcher("products-update.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String qty = req.getParameter("qty");
//        String imageString = req.getParameter("productImage");
        String category1 = req.getParameter("category");

        Part file = req.getPart("product_img");
        String imgFilename  = file.getSubmittedFileName();
        String productImage = "images/" + imgFilename;
        String uploadPath = "C:\\Users\\Win10-LL\\Documents\\IJSE\\ASSIGNMENT_JSP\\src\\main\\webapp\\img\\"+imgFilename;
        FileOutputStream fos = new FileOutputStream(uploadPath);
        InputStream is = file.getInputStream();

        try {

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }




        CategoryDto categoryDto = categoryBo.searchByCategoryId(category1);

        Category category = new Category(categoryDto.getCid(),categoryDto.getCname(),categoryDto.getCreatedAt());

        ProductsDto products = new ProductsDto(id, name, qty, price, productImage, category);

        boolean b = productsBo.updateProducts(products);

        if (b) {
//            req.getSession().setAttribute("registrationStatus", "success");
            resp.sendRedirect("products-update.jsp");
        } else {
//            req.getSession().setAttribute("registrationStatus", "error");
            resp.sendRedirect("AdminDash.jsp");
        }


    }
}
