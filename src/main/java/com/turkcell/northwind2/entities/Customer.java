package com.turkcell.northwind2.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String customerId, String companyName, List<Order> orders) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.orders = orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
