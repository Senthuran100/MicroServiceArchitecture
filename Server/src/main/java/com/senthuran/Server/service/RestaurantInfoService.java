package com.senthuran.Server.service;

import com.senthuran.Server.model.Restaurant;
import com.senthuran.Server.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RestaurantInfoService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant> findAllRestaurant() {
        return restaurantRepo.findAll();
    }

    public List<Restaurant> findRestaurantsByNameContains(String restaurantName) {
        return restaurantRepo.findByRestaurantName(restaurantName);
    }

    public void createRestaurant(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
    }


}
