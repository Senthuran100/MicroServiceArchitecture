package com.senthuran.Server.controller;

import com.senthuran.Server.model.Restaurant;
import com.senthuran.Server.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class RestaurantController {

    @Autowired
    RestaurantInfoService restaurantInfoService;

    @RequestMapping(value = "/restaurants",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllRestaurant() {
        return restaurantInfoService.findAllRestaurant();
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Created ")
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantInfoService.createRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Restaurant> getRestaurantByName(@RequestParam(value = "name") String name) {
        return restaurantInfoService.findRestaurantsByNameContains(name);
    }
}
