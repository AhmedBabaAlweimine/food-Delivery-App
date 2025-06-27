package com.alweimine.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Integer orderId;
    private List<FoodItemDto> foodItemList;
    private Restaurant restaurant;
    private UserDto userDto;
}
