package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.DaoLayer.Dao.ProductsDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.dto.ProductsDto;

public class ProductsBoImpl implements ProductsBo {

    ProductsDao productsDao = (ProductsDao) DaoFactory.getDaoFactory().getDao(DaoType.PRODUCT);
    @Override
    public boolean saveProducts(ProductsDto products) {
        Products products1 = new Products(products.getPid(), products.getName(), products.getQty(), products.getPrice(), products.getImage());
        return productsDao.save(products1);
    }

    @Override
    public boolean deleteProducts(String id) {
       return productsDao.delete(id);
    }

    @Override
    public boolean updateProducts(ProductsDto products) {
        Products products1 = new Products(products.getPid(), products.getName(), products.getQty(), products.getPrice(), products.getImage());
        return productsDao.update(products1);
    }
}
