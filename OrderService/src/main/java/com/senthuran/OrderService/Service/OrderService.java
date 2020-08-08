package com.senthuran.OrderService.Service;


import com.senthuran.OrderService.Repository.ItemRepo;
import com.senthuran.OrderService.Repository.OrderInfoRepo;
import com.senthuran.OrderService.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderInfoRepo orderInfoRepo;

    public List<OrderInfo> saveOrdersByRestaurantId(long restaurantId, List<OrderInfo> orderInfos){
        for(OrderInfo orderInfo: orderInfos){
            orderInfo.setRestaurantId(restaurantId);
        }
       return orderInfoRepo.saveAll(orderInfos);
    }

    public List<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList) {
        return orderInfoRepo.saveAll(orderInfoList);
    }

    public Page<OrderInfo> showOrdersByRestaurant(long restaurantId, Pageable pageable) {
        return orderInfoRepo.findByRestaurantId(restaurantId, pageable);
    }

    public Page<OrderInfo> showOrders( Pageable pageable) {
        return orderInfoRepo.findAll(pageable);
    }

    public Page<OrderInfo> showOrdersByUser(String userId, Pageable pageable) {
        return orderInfoRepo.findByUserName(userId, pageable);
    }

    public void deleteOrder(String orderId) {
        orderInfoRepo.deleteByOrderId(orderId);
    }

    public OrderInfo findFirstByOrderId(String orderId) {
        return orderInfoRepo.findFirstByOrderId(orderId);
    }

    public void updateOrderStatus(String orderId, OrderInfo.OrderStatus orderStatus) {

        OrderInfo orderInfo = findFirstByOrderId(orderId);
        orderInfo.setOrderStatus(orderStatus);
        orderInfoRepo.save(orderInfo);
    }

}
