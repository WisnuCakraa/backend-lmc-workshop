package com.nunu.lmc.Service;

import com.nunu.lmc.Constants;
import com.nunu.lmc.Entity.Category;
import com.nunu.lmc.Entity.ErrorException;
import com.nunu.lmc.Repository.CategoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName"));
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public  void deleteCategory(Integer categoryId) {
        boolean exist = categoryRepository.existsById(categoryId);
        ErrorException error = new ErrorException(Constants.ID_NOT_EXIST_ERROR_CODE, "Category ID doesnt exist");

        if(!exist) {
            throw new IllegalStateException(error.getFullErrorMessage());
        }

        categoryRepository.deleteById(categoryId);
    }
}
