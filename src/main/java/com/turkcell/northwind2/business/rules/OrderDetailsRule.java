package com.turkcell.northwind2.business.rules;

import com.turkcell.northwind2.dataAccess.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailsRule {
    private final OrderDetailRepository orderDetailRepository;

    public int stockQuantity(int quantity, int id) {
        int stock = orderDetailRepository.stock(id);
        if (quantity <= stock && quantity <= 5) {
            stock -= quantity;
        }
        return stock;
    }
}
