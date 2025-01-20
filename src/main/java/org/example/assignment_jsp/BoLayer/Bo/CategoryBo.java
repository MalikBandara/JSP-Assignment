package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.dto.CategoryDto;

import java.util.List;

public interface CategoryBo extends SuperBo {
    boolean saveCategory(CategoryDto categoryDto);

    boolean deleteProducts(String id);

    boolean UpdateCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategory();

    CategoryDto searchByCategoryId(String category1);
}
