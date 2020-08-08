package com.senthuran.OrderService.Controller;

import com.senthuran.OrderService.Service.OrderService;
import com.senthuran.OrderService.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/{restaurantId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderInfo> saveOrdersByRestaurantId(@PathVariable long restaurantId, @RequestBody List<OrderInfo> orderInfoList) {
        return orderService.saveOrdersByRestaurantId(restaurantId, orderInfoList);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderInfo> saveOrders(@RequestBody List<OrderInfo> orderInfoList) {
        return orderService.saveOrderInfos(orderInfoList);
    }

    @RequestMapping(value = "/order/{restaurantId}")
    public Page<OrderInfo> viewOrdersByRestaurant(@PathVariable long restaurantId, Pageable pageable) {
        return orderService.showOrdersByRestaurant(restaurantId, pageable);
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public  Page<OrderInfo> showOrders(Pageable pageable){
        return orderService.showOrders(pageable);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.PUT)
    public void updateOrderStatus(@PathVariable String orderId, @ModelAttribute OrderInfo.OrderStatus orderStatus){
        orderService.updateOrderStatus(orderId, orderStatus);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }
}
