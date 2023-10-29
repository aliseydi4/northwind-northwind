package com.turkcell.northwind2.dto.productDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateProductRequest {
    @NotBlank
    private String productName;
    @NotNull
    private int categoryId;
    @Min(0)
    private double unitPrice;
    @Min(0)
    private int unitInStock;
    private short discontinued;

    public CreateProductRequest() {
    }

    public CreateProductRequest(String productName, int categoryId, double unitPrice, int unitInStock, short discontinued) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.discontinued = discontinued;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public short getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(short discontinued) {
        this.discontinued = discontinued;
    }
}
