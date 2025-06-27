package com.alweimine.foodcatalogue.controller;

import com.alweimine.foodcatalogue.dto.FoodCataloguePage;
import com.alweimine.foodcatalogue.dto.FoodItemDto;
import com.alweimine.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {
    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping //addFoodItem
    public ResponseEntity<FoodItemDto> saveFoodItem(@RequestBody FoodItemDto foodItemDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(foodCatalogueService.saveFoodItem(foodItemDto));
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu(@PathVariable(name = "id") Integer restaurantId){
        FoodCataloguePage foodCataloguePage=foodCatalogueService.fetchFoodCtalogueDetails(restaurantId);
        return ResponseEntity.ok(foodCataloguePage);
    }

}
