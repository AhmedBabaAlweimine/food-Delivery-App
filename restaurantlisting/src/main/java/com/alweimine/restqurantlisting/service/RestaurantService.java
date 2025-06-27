package com.alweimine.restqurantlisting.service;

import com.alweimine.restqurantlisting.dto.RestaurantDto;
import com.alweimine.restqurantlisting.entity.Restaurant;
import com.alweimine.restqurantlisting.mapper.RestaurantMapper;
import com.alweimine.restqurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepo.findAll().stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).collect(Collectors.toList());
    }

    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        return RestaurantMapper.INSTANCE.
                mapRestaurantToRestaurantDto(restaurantRepo.
                        save(RestaurantMapper.INSTANCE.
                                mapRestaurantDtoToRestaurant(restaurantDto)));
    }

    public RestaurantDto getRestaurant(Integer restauranId) {
        Restaurant restaurant=restaurantRepo.findById(restauranId).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }
}
