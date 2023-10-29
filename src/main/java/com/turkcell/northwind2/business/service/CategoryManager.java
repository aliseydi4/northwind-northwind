package com.turkcell.northwind2.business.service;

import com.turkcell.northwind2.business.rules.CategoryRule;
import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.CategoryRepository;
import com.turkcell.northwind2.dto.categoryDto.*;
import com.turkcell.northwind2.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryManager {
    private final CategoryRepository categoryRepository;
    private final CategoryRule categoryRule;

    public CategoryManager(CategoryRepository categoryRepository, CategoryRule categoryRule) {
        this.categoryRepository = categoryRepository;
        this.categoryRule = categoryRule;
    }

    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> responses = new ArrayList<>();
        for (Category category : categories) {
            GetAllCategoriesResponse response = new GetAllCategoriesResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            response.setDescription(category.getDescription());
            responses.add(response);
        }
        return responses;
    }

    public GetByIdCategoryResponse getByIdCategoryResponse(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new BusinessException("not found id" + id));
        GetByIdCategoryResponse response = new GetByIdCategoryResponse();
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        return response;
    }

    public void add(CreateCategoryRequest createCategoryRequest) {
        categoryRule.checkIfCategoryNameExists(createCategoryRequest.getName());
        Category category = new Category();
        category.setName(createCategoryRequest.getName());
        category.setDescription(createCategoryRequest.getDescription());

        categoryRepository.save(category);
    }
    public Category update(UpdateCategoryRequest updateCategoryRequest){
        categoryRule.checkIfCategoryNameExists(updateCategoryRequest.getName());
        categoryRule.checkIfCategoryIdExists(updateCategoryRequest.getId());
        Category category=new Category();
        category.setId(updateCategoryRequest.getId());
        category.setName(updateCategoryRequest.getName());
        category.setDescription(updateCategoryRequest.getDescription());
        return categoryRepository.save(category);
    }
    public void delete(int id){
        categoryRule.checkIfCategoryIdExists(id);
        categoryRepository.deleteById(id);
    }
@Transactional
    public void updateName(String name,String des,int id){
    categoryRepository.update(name,des,id);

    }
}
