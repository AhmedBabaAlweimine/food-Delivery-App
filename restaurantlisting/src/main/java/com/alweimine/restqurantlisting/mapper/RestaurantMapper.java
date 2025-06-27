package com.alweimine.restqurantlisting.mapper;

import com.alweimine.restqurantlisting.dto.RestaurantDto;
import com.alweimine.restqurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}
