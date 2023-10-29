package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.dto.orderDto.GetAllOrderResponse;

import com.turkcell.northwind2.entities.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {


    @Query(value = "select new " +
            "com.turkcell.northwind2.dto.orderDto.GetAllOrderResponse" +
            "(o.orderId,o.orderDate,o.requiredDate,o.shippedDate,o.shipName,o.shipAddress,c.customerId,e.employeeId)" +
            "from Order o inner join o.customer c inner join o.employee e ")
    List<GetAllOrderResponse>getAll();



}
