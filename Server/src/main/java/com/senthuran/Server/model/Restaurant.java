package com.senthuran.Server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(unique = true)
    private String restaurantName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Restaurant_Item", joinColumns = {
            @JoinColumn(name = "RestaurantId") }, inverseJoinColumns = {
            @JoinColumn(name = "ItemId") })
    private Set<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant() {
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Restaurant(String restaurantName, Set<Item> items) {
        this.restaurantName = restaurantName;
        this.items = items;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
