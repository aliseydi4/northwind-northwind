package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    boolean existsByCustomerId(String name);
}
