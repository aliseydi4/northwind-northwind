package com.turkcell.northwind2.controllers;

import com.turkcell.northwind2.business.service.ProductManager;
import com.turkcell.northwind2.dto.categoryDto.GetByIdCategoryResponse;
import com.turkcell.northwind2.dto.productDto.CreateProductRequest;
import com.turkcell.northwind2.dto.productDto.GetAllProductResponse;
import com.turkcell.northwind2.dto.productDto.GetByIdProductResponse;
import com.turkcell.northwind2.dto.productDto.UpdateProductRequest;
import com.turkcell.northwind2.entities.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductsController {
    private final ProductManager productManager;

    public ProductsController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("getAll")
    public List<GetAllProductResponse> getAll() {
        return productManager.getAll();
    }


    @GetMapping("getById")
    public GetByIdProductResponse getById(@RequestParam("id") int id) {
        return productManager.getById(id);
    }

    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateProductRequest add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return productManager.add(createProductRequest);
    }

    @PutMapping("update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UpdateProductRequest update(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
        return productManager.update(updateProductRequest);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") int id) {
        productManager.delete(id);
    }
}
