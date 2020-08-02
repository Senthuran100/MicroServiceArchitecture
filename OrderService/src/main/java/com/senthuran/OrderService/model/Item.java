package com.senthuran.OrderService.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Item {
    @Id
    @GeneratedValue
    private long id;

    private long foodId;
    private String foodName;
    private String description;
    private String restaurantName;
    private double price;
    private int quantity;
    private long restaurantId;

    @ManyToOne
    private OrderInfo orderInfo;


    public Item(long foodId, String foodName, String description, double price, int quantity, long restaurantId, OrderInfo orderInfo) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.restaurantId = restaurantId;
        this.orderInfo = orderInfo;
    }

}
