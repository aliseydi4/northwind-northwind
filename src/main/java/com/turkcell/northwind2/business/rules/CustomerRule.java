package com.turkcell.northwind2.business.rules;

import com.turkcell.northwind2.core.utilities.exception.BusinessException;
import com.turkcell.northwind2.dataAccess.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerRule {
    private final CustomerRepository customerRepository;

    public CustomerRule(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void checkIfCustomerIdExists(String name){
        if (!customerRepository.existsByCustomerId(name)){
            throw new BusinessException("not found customerId");
        }
    }
}
