package com.turkcell.northwind2.business.rules;

import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.CategoryRepository;
import com.turkcell.northwind2.dataAccess.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductRule {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductRule(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public void checkIfCategoryIdExists(int id){
        if (!categoryRepository.existsById(id)){
            throw new BusinessException("not found id");
        }
    }
    public void checkIfProductIdExists(int id){
        productRepository.findById(id).orElseThrow(()->new BusinessException("not found ıd"));
    }

}
