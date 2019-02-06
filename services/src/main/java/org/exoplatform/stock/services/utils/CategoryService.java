package org.exoplatform.stock.services.utils;

import org.exoplatform.stock.dao.CategoryDao;
import org.exoplatform.stock.entity.Category;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao;

    /**
     *
     * @param categoryDao
     */
    public CategoryService(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

    public List<Category> getAllCategories(){
        return this.categoryDao.findAll();
    }
}
