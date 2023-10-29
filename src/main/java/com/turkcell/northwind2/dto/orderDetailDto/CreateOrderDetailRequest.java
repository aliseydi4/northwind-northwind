package com.turkcell.northwind2.dto.orderDetailDto;

import jakarta.persistence.Column;

public class CreateOrderDetailRequest {



    private int productId;

    private int quantity;

    public CreateOrderDetailRequest() {
    }

    public CreateOrderDetailRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
