package com.senthuran.OrderService.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderInfo {

    public enum OrderStatus{
        Created, Processing, Paid, Finished, Cancelled
    }

    @Id
    @GeneratedValue
    private Long id;

    private String orderId;
    private String userName;
    private String deliveryAddress;
    private long restaurantId;
    private String restaurantName;
    private String dietNote;
    private Date timestamp = new Date();
    private OrderStatus orderStatus = OrderStatus.Created;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "orderInfo")
    private List<Item> items = new ArrayList<>();

    public OrderInfo() {}

    @JsonCreator
    public OrderInfo(Long id) {
        this.id = id;
    }

    public OrderInfo(String orderId, String userName, String restaurantName) {
        this.orderId = orderId;
        this.userName = userName;
        this.restaurantName = restaurantName;
    }

    public OrderInfo(String orderId, String userName, long restaurantId, String deliveryAddress, String restaurantName, String dietNote) {
        this.orderId = orderId;
        this.userName = userName;
        this.restaurantId = restaurantId;
        this.deliveryAddress = deliveryAddress;
        this.restaurantName = restaurantName;
        this.dietNote = dietNote;
        this.orderStatus = OrderStatus.Processing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDietNote() {
        return dietNote;
    }

    public void setDietNote(String dietNote) {
        this.dietNote = dietNote;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
