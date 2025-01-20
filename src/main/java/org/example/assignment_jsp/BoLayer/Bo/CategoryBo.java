package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.dto.CategoryDto;

public interface CategoryBo extends SuperBo {
    boolean saveCategory(CategoryDto categoryDto);

    boolean deleteProducts(String id);

    boolean UpdateCategory(CategoryDto categoryDto);
}
