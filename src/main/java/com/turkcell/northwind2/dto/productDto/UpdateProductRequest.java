package com.turkcell.northwind2.dto.productDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateProductRequest {
    @NotNull
    private int productId;
    @NotBlank
    private String productName;
    @NotNull
    private int categoryId;
    @Min(0)
    private double unitPrice;
    @Min(0)
    private int unitInStock;
    private short discontinued;

    public UpdateProductRequest() {
    }

    public UpdateProductRequest(String productName, int categoryId, double unitPrice, int unitInStock, short discontinued,int productId) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.discontinued = discontinued;
        this.productId=productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
