package com.alweimine.restqurantlisting.controller;

import com.alweimine.restqurantlisting.dto.RestaurantDto;
import com.alweimine.restqurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return new ResponseEntity(restaurantService.saveRestaurant(restaurantDto), HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{restauranId}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Integer restauranId) {
        return ResponseEntity.ok(restaurantService.getRestaurant(restauranId));
    }

}
