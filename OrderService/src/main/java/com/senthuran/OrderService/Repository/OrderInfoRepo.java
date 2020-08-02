package com.senthuran.OrderService.Repository;
import com.senthuran.OrderService.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface OrderInfoRepo extends JpaRepository<OrderInfo,Long> {

    Page<OrderInfo> findByRestaurantId(String restaurantId, Pageable pageable);
    Page<OrderInfo> findByUserName(String userName, Pageable pageable);
    OrderInfo findFirstByOrderId(String orderId);
    void deleteByOrderId(String OrderId);

}
