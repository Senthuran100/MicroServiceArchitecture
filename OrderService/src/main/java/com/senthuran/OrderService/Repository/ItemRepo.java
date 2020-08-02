package com.senthuran.OrderService.Repository;
import com.senthuran.OrderService.model.Item;
import com.senthuran.OrderService.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Long> {

    List<Item> findByOrderInfo(OrderInfo orderInfo);
    List<Item> findByRestaurantId(String restaurantId);
}
