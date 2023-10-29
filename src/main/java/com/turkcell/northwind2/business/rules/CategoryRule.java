package com.turkcell.northwind2.business.rules;

import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryRule {
    private final CategoryRepository categoryRepository;

    public CategoryRule(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void checkIfCategoryNameExists(String name){
        if (categoryRepository.existsByName(name)){
            throw new BusinessException("category name must be unique");
        }
    }
    public void checkIfCategoryIdExists(int id){
        categoryRepository.findById(id).orElseThrow(()->new BusinessException("not found id "+id));
    }
}
