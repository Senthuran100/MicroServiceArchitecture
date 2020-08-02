package com.senthuran.OrderService.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}
