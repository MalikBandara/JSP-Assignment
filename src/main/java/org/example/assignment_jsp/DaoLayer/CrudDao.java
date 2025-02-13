package org.example.assignment_jsp.DaoLayer;

import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.dto.ProductsDto;

import java.util.List;

public interface CrudDao <T> extends SuperDao{
    boolean save(T user1);

    boolean Login(String email, String password);

    boolean delete(String id);

    boolean update(T t);

    List<T> getAll();

    Category getCategoryById(String category1);
}
