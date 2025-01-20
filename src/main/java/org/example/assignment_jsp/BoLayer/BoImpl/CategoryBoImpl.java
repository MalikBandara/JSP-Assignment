package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.DaoLayer.Dao.CategoryDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryBoImpl implements CategoryBo {

    CategoryDao categoryDao = (CategoryDao) DaoFactory.getDaoFactory().getDao(DaoType.CATEGORY);

    @Override
    public boolean saveCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getCid(), categoryDto.getCname(), categoryDto.getCreatedAt());
        return categoryDao.save(category);
    }

    @Override
    public boolean deleteProducts(String id) {
       return categoryDao.delete(id);
    }

    @Override
    public boolean UpdateCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getCid(), categoryDto.getCname(), categoryDto.getCreatedAt());
        return categoryDao.update(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> all = categoryDao.getAll();

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category : all){
            CategoryDto dto = new CategoryDto();
            dto.setCid(category.getCid());
            dto.setCname(category.getCname());
            dto.setCreatedAt(category.getCreatedAt());

            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto searchByCategoryId(String category1) {
        Category categoryById = categoryDao.getCategoryById(category1);
        CategoryDto categoryDto = new CategoryDto(categoryById.getCid(),categoryById.getCname(),categoryById.getCreatedAt());
        return categoryDto;
    }
}
