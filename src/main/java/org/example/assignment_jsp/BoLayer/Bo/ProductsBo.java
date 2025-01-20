package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.dto.ProductsDto;

public interface ProductsBo extends SuperBo {
    boolean saveProducts(ProductsDto products);
}
