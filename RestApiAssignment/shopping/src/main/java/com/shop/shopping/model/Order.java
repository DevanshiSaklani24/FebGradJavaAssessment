package com.shop.shopping.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private String orderName;

    //private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
    private Integer quantity;
    private Double Sum;

    public Order() {
    }

    public Order(Integer quantity) {
        this.quantity = quantity;
    }

    public Order(Integer quantity, String orderName, Product product) {
        this.quantity = quantity;
        this.orderName = orderName;
        this.product = product;
    }

    public Order(Product product, int quantity, String orderName) {
        this.product = product;
        this.quantity = quantity;
        this.orderName = orderName;
        this.Sum = this.quantity*this.product.getProductPrice();
    }

    public Order(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSum() {
        return Sum;
    }

    public void setSum(Double sum) {
        Sum = sum;
    }
}
