package com.turkcell.northwind2.business.service;

import com.turkcell.northwind2.business.rules.ProductRule;
import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.ProductRepository;
import com.turkcell.northwind2.dto.productDto.CreateProductRequest;
import com.turkcell.northwind2.dto.productDto.GetAllProductResponse;
import com.turkcell.northwind2.dto.productDto.GetByIdProductResponse;
import com.turkcell.northwind2.dto.productDto.UpdateProductRequest;
import com.turkcell.northwind2.entities.Category;
import com.turkcell.northwind2.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager {
    private final ProductRepository productRepository;
    public final ProductRule productRule;

    public ProductManager(ProductRepository productRepository, ProductRule productRule) {
        this.productRepository = productRepository;
        this.productRule = productRule;
    }

    public List<GetAllProductResponse>getAll(){
        List<Product>products=productRepository.findAll();
        List<GetAllProductResponse>responses=new ArrayList<>();
        for (Product product:products){
            GetAllProductResponse response=new GetAllProductResponse();
            response.setProductId(product.getProductId());
            response.setProductName(product.getProductName());
            response.setDiscontinued(product.getDiscontinued());
            response.setReorderLevel(product.getReorderLevel());
            response.setQuantityPerUnit(product.getQuantityPerUnit());
            response.setUnitInStock(product.getUnitInStock());
            response.setUnitPrice(product.getUnitPrice());
           response.setCategoryId(product.getCategory().getId());
           responses.add(response);
        }
        return responses;
    }
    public GetByIdProductResponse getById(int id){
        Product product=productRepository.findById(id).orElseThrow(()->new BusinessException("not found id "+id));
        GetByIdProductResponse response=new GetByIdProductResponse();
        response.setProductId(product.getProductId());
        response.setProductName(product.getProductName());
        response.setDiscontinued(product.getDiscontinued());
        response.setUnitPrice(product.getUnitPrice());
        response.setUnitInStock(product.getUnitInStock());
        response.setCategoryName(product.getCategory().getName());
        return response;
    }
    public CreateProductRequest add(CreateProductRequest createProductRequest){
        productRule.checkIfCategoryIdExists(createProductRequest.getCategoryId());
        Product product=new Product();
        product.setProductName(createProductRequest.getProductName());
        product.setDiscontinued(createProductRequest.getDiscontinued());
        product.setUnitInStock(createProductRequest.getUnitInStock());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        Category category=new Category();
        category.setId(createProductRequest.getCategoryId());
        product.setCategory(category);
        productRepository.save(product);
        return new CreateProductRequest(createProductRequest.getProductName(),createProductRequest.getDiscontinued(),createProductRequest.getUnitPrice(),createProductRequest.getUnitInStock(),createProductRequest.getDiscontinued());
    }
    public UpdateProductRequest update(UpdateProductRequest updateProductRequest){
        productRule.checkIfCategoryIdExists(updateProductRequest.getCategoryId());
        productRule.checkIfProductIdExists(updateProductRequest.getProductId());
        Product product=new Product();
        product.setProductId(updateProductRequest.getProductId());
        product.setProductName(updateProductRequest.getProductName());
        product.setDiscontinued(updateProductRequest.getDiscontinued());
        product.setUnitPrice(updateProductRequest.getUnitPrice());
        Category category=new Category();
        category.setId(updateProductRequest.getCategoryId());
        product.setCategory(category);
        productRepository.save(product);
        return new UpdateProductRequest(updateProductRequest.getProductName(), updateProductRequest.getCategoryId(), updateProductRequest.getUnitPrice(), updateProductRequest.getUnitInStock(), updateProductRequest.getDiscontinued(), updateProductRequest.getCategoryId());
    }
    public void delete(int id){
        productRule.checkIfProductIdExists(id);
        productRepository.deleteById(id);
    }

}
