package com.turkcell.northwind2.dto.orderDto;

import java.time.LocalDate;

public class GetByIdOrderResponse {
    private int orderId;
    private LocalDate orderDate;
    private String shipName;
    private String shipAddress;
    private String customerId;
    private int employeeId;

    public GetByIdOrderResponse() {
    }

    public GetByIdOrderResponse(int orderId, LocalDate orderDate, String shipName, String shipAddress, String customerId, int employeeId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
