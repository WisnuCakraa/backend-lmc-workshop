package com.nunu.lmc.Controller;

import com.nunu.lmc.Entity.Category;
import com.nunu.lmc.Entity.ErrorException;
import com.nunu.lmc.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping(path = "/add")
    public void addNewCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @DeleteMapping(path = "/delete/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Integer categoryId) throws ErrorException {
        categoryService.deleteCategory(categoryId);
    }
}
