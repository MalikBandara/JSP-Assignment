package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.dto.ProductsDto;

import java.util.List;

public interface ProductsBo extends SuperBo {
    boolean saveProducts(ProductsDto products);

    boolean deleteProducts(String id);

    boolean updateProducts(ProductsDto products);

    List<ProductsDto> getAllProducts();

    List<ProductsDto> getProductByCategoryId(String categoryId);

    ProductsDto getProductId(String id);
}
