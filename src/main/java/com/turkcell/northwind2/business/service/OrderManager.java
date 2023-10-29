package com.turkcell.northwind2.business.service;

import com.turkcell.northwind2.business.rules.CustomerRule;
import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.OrderRepository;
import com.turkcell.northwind2.dto.orderDto.CreateOrderRequest;
import com.turkcell.northwind2.dto.orderDto.GetAllOrderResponse;
import com.turkcell.northwind2.dto.orderDto.GetByIdOrderResponse;
import com.turkcell.northwind2.entities.Customer;

import com.turkcell.northwind2.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderManager {
    private final OrderRepository orderRepository;
    private final OrderDetailManager orderDetailManager;
    private final CustomerRule customerRule;


    public OrderManager(OrderRepository orderRepository, OrderDetailManager orderDetailManager, CustomerRule customerRule) {
        this.orderRepository = orderRepository;
        this.orderDetailManager = orderDetailManager;
        this.customerRule = customerRule;
    }

    public List<GetAllOrderResponse>getAll(){
        return orderRepository.getAll();
    }
    public GetByIdOrderResponse getById(int id){
        Order order=orderRepository.findById(id).orElseThrow(()->new BusinessException("not found order id"));
        GetByIdOrderResponse orderResponse=new GetByIdOrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setShipName(order.getShipName());
        orderResponse.setShipAddress(order.getShipAddress());
        orderResponse.setCustomerId(order.getCustomer().getCustomerId());
        return orderResponse;
    }
@Transactional
    public void add(CreateOrderRequest createOrderRequest){
        customerRule.checkIfCustomerIdExists(createOrderRequest.getCustomerId());
        Order order=new Order();
        order.setOrderDate(LocalDate.now());
        order.setRequiredDate(createOrderRequest.getRequiredDate());
        order.setShipAddress(createOrderRequest.getShipAddress());
        order.setShipName(createOrderRequest.getShipName());
        Customer customer=new Customer();
        customer.setCustomerId(createOrderRequest.getCustomerId());
        order.setCustomer(customer);
        order=orderRepository.save(order);
        orderDetailManager.add(order,createOrderRequest.getItems());
    }
}
