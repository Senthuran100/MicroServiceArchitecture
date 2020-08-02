package com.senthuran.OrderService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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

    public Item(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
