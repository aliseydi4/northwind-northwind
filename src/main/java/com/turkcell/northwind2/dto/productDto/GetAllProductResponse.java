package com.turkcell.northwind2.dto.productDto;

import jakarta.persistence.Column;

public class GetAllProductResponse {
    private int productId;
    private String productName;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitInStock;
    private int unitOnOrder;
    private int reorderLevel;
    private short discontinued;

    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }



    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
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

    public int getUnitOnOrder() {
        return unitOnOrder;
    }

    public void setUnitOnOrder(int unitOnOrder) {
        this.unitOnOrder = unitOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public short getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(short discontinued) {
        this.discontinued = discontinued;
    }

    public GetAllProductResponse() {
    }

    public GetAllProductResponse(int productId, String productName, String quantityPerUnit, double unitPrice, int unitInStock, int unitOnOrder, int reorderLevel, short discontinued, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.unitOnOrder = unitOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
        this.categoryId = categoryId;
    }
}
