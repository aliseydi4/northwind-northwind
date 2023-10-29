package com.turkcell.northwind2.dto.productDto;

public class GetByIdProductResponse {
    private int productId;
    private String productName;

    private double unitPrice;
    private int unitInStock;

    private short discontinued;
    private String categoryName;

    public GetByIdProductResponse() {
    }

    public GetByIdProductResponse(int productId, String productName, double unitPrice, int unitInStock, short discontinued, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.discontinued = discontinued;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
