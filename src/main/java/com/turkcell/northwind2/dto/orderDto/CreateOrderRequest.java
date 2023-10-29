package com.turkcell.northwind2.dto.orderDto;

import com.turkcell.northwind2.dto.orderDetailDto.CreateOrderDetailRequest;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class CreateOrderRequest {
    @Future
    private LocalDate requiredDate;
    private String shipName;
    private String shipAddress;
    @NotBlank
    private String customerId;
    private List<CreateOrderDetailRequest> items;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(LocalDate requiredDate, String shipName, String shipAddress, String customerId, List<CreateOrderDetailRequest> items) {
        this.requiredDate = requiredDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.customerId = customerId;
        this.items = items;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
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

    public List<CreateOrderDetailRequest> getItems() {
        return items;
    }

    public void setItems(List<CreateOrderDetailRequest> items) {
        this.items = items;
    }
}
