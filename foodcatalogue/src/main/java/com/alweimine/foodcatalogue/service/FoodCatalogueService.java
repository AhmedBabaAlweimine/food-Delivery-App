package com.alweimine.foodcatalogue.service;

import com.alweimine.foodcatalogue.dto.FoodCataloguePage;
import com.alweimine.foodcatalogue.dto.FoodItemDto;
import com.alweimine.foodcatalogue.dto.Restaurant;
import com.alweimine.foodcatalogue.entity.FoodItem;
import com.alweimine.foodcatalogue.mapper.FoodItemMapper;
import com.alweimine.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogueService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDto saveFoodItem(FoodItemDto foodItemDto) {
        return FoodItemMapper.INSTANCE.
                mapFoodItemToFoodItemDto(foodItemRepo.
                        save(FoodItemMapper.INSTANCE.
                                mapFoodItemDtoToFoodItem(foodItemDto)));
    }

    //this method will fetch Fooditemlist and should call Restaurant Micro service to get restaurant details also
    public FoodCataloguePage fetchFoodCtalogueDetails(Integer restaurantId) {
        List<FoodItem> foodItems = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createCataloguePage(foodItems, restaurant);
    }

    private FoodCataloguePage createCataloguePage(List<FoodItem> foodItems, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItems);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
