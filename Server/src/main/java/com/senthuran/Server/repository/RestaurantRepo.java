package com.senthuran.Server.repository;

import com.senthuran.Server.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findByRestaurantName(String restaurantName);
}
