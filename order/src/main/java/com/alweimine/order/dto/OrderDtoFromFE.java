package com.alweimine.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFE {
private Restaurant restaurant;
private List<FoodItemDto> foodItemsList;
private Integer userId;
}
