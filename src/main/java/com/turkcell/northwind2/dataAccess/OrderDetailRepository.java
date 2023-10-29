package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.entities.OrderDetail;
import com.turkcell.northwind2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query("select p.unitPrice from Product p where p.productId=?1")
    double unitPrice(int id);
    @Modifying
    @Query("update Product as p set p.unitInStock=?1 where p.productId=?2")
    void unitStock(int stock,int id);

    @Query("select p.unitInStock from Product as p where p.productId=?1" )
    int stock(int id);
}
