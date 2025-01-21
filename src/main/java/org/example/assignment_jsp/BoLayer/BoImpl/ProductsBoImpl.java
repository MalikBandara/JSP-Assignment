package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.ProductsBo;
import org.example.assignment_jsp.DaoLayer.Dao.ProductsDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.dto.ProductsDto;

import java.util.ArrayList;
import java.util.List;

public class ProductsBoImpl implements ProductsBo {

    ProductsDao productsDao = (ProductsDao) DaoFactory.getDaoFactory().getDao(DaoType.PRODUCT);
    @Override
    public boolean saveProducts(ProductsDto products) {
        Products products1 = new Products(products.getPid(), products.getName(), products.getQty(), products.getPrice(), products.getImage(),products.getCategory());
        return productsDao.save(products1);
    }

    @Override
    public boolean deleteProducts(String id) {
       return productsDao.delete(id);
    }

    @Override
    public boolean updateProducts(ProductsDto products) {
        Products products1 = new Products(products.getPid(), products.getName(), products.getQty(), products.getPrice(), products.getImage(),products.getCategory());
        return productsDao.update(products1);
    }

    @Override
    public List<ProductsDto> getAllProducts() {
        List<Products> all = productsDao.getAll();

        List<ProductsDto> productDtoList = new ArrayList<>();

        for (Products product : all){
            ProductsDto dto = new ProductsDto();
            dto.setPid(product.getPid());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setQty(product.getQty()); // Assuming `category` is a direct mapping
            dto.setImage(product.getImage()); // Example additional fields
            productDtoList.add(dto); // Add the DTO to the list
        }
        System.out.println("Converting Products to ProductsDto...");
        for (Products product : all) {
            System.out.println("Converting Product ID: " + product.getPid());
        }

        return productDtoList;

    }

    @Override
    public List<ProductsDto> getProductByCategoryId(String categoryId) {
        List<Products> productsByCategory = productsDao.getProductsByCategory(categoryId);

        List<ProductsDto> productsDtos = new ArrayList<>();

        for (Products products : productsByCategory){
            ProductsDto productsDto = new ProductsDto();
            productsDto.setPid(products.getPid());
            productsDto.setName(products.getName());
            productsDto.setCategory(products.getCategory());
            productsDto.setQty(products.getQty());
            productsDto.setPrice(products.getPrice());
            productsDto.setImage(products.getImage());

            productsDtos.add(productsDto);

        }
        return productsDtos;
    }
}
