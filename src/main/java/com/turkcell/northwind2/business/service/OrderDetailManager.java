package com.turkcell.northwind2.business.service;

import com.turkcell.northwind2.business.rules.OrderDetailsRule;
import com.turkcell.northwind2.business.rules.ProductRule;
import com.turkcell.northwind2.dataAccess.OrderDetailRepository;
import com.turkcell.northwind2.dto.orderDetailDto.CreateOrderDetailRequest;
import com.turkcell.northwind2.entities.Order;
import com.turkcell.northwind2.entities.OrderDetail;
import com.turkcell.northwind2.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailManager {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRule productRule;
    private final OrderDetailsRule orderDetailsRule;

    public OrderDetailManager(OrderDetailRepository orderDetailRepository, ProductRule productRule, OrderDetailsRule orderDetailsRule) {
        this.orderDetailRepository = orderDetailRepository;
        this.productRule = productRule;
        this.orderDetailsRule = orderDetailsRule;
    }

    public void add(Order order, List<CreateOrderDetailRequest> items) {

        for (CreateOrderDetailRequest item : items) {
        int stock=orderDetailsRule.stockQuantity(item.getQuantity(),item.getProductId());

            orderDetailRepository.unitStock(stock, item.getProductId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(item.getQuantity());
            Product product = new Product();
            product.setProductId(item.getProductId());
            orderDetail.setProduct(product);
            orderDetail.setUnitPrice(orderDetailRepository.unitPrice(item.getProductId()));
            orderDetail.setOrder(order);
            productRule.checkIfProductIdExists(item.getProductId());

            orderDetailRepository.save(orderDetail);

        }

    }
}
