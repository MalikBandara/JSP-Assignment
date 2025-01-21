package org.example.assignment_jsp.DaoLayer.Dao;

import org.example.assignment_jsp.DaoLayer.CrudDao;
import org.example.assignment_jsp.Entity.Products;

import java.util.List;

public interface ProductsDao extends CrudDao<Products> {
    List<Products> getProductsByCategory(String categoryId);

}
