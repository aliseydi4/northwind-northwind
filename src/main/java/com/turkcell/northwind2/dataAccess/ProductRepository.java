package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {



}
