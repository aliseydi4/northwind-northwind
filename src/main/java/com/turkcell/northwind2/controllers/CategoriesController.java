package com.turkcell.northwind2.controllers;

import com.turkcell.northwind2.business.service.CategoryManager;
import com.turkcell.northwind2.dto.categoryDto.*;
import com.turkcell.northwind2.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoriesController {
    private final CategoryManager categoryManager;

    public CategoriesController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }
    @GetMapping("getAll")
    public List<GetAllCategoriesResponse>getAll(){
        return categoryManager.getAll();
    }
    @GetMapping("getById")
    public GetByIdCategoryResponse getById(@RequestParam("id") int id){
        return categoryManager.getByIdCategoryResponse(id);
    }
    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest){
      categoryManager.add(createCategoryRequest);
    }
    @PutMapping("update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category update(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest) {
        return categoryManager.update(updateCategoryRequest);
    }
    @DeleteMapping("delete")
    public void delete(@RequestParam("id") int id){
        categoryManager.delete(id);
    }

    @PutMapping("updateName/{id}")
    public void updateName( @PathVariable int id, String name,String des) {
            categoryManager.updateName(name,des,id);
    }
    }
