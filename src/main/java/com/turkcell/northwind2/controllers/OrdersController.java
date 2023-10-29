package com.turkcell.northwind2.controllers;

import com.turkcell.northwind2.business.service.OrderManager;
import com.turkcell.northwind2.dto.orderDto.CreateOrderRequest;
import com.turkcell.northwind2.dto.orderDto.GetAllOrderResponse;
import com.turkcell.northwind2.dto.orderDto.GetByIdOrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController {
    private final OrderManager orderManager;

    public OrdersController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping("getAll")
    public List<GetAllOrderResponse> getAll() {
        return orderManager.getAll();
    }

    @GetMapping("getByID")
    public GetByIdOrderResponse getById(@RequestParam("id") int id) {
        return orderManager.getById(id);
    }

    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        orderManager.add(createOrderRequest);
    }
}
