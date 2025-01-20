package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.CategoryBo;
import org.example.assignment_jsp.DaoLayer.Dao.CategoryDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.dto.CategoryDto;

public class CategoryBoImpl implements CategoryBo {

    CategoryDao categoryDao = (CategoryDao) DaoFactory.getDaoFactory().getDao(DaoType.CATEGORY);

    @Override
    public boolean saveCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getCid(), categoryDto.getCname(), categoryDto.getCreatedAt());
        return categoryDao.save(category);
    }
}
