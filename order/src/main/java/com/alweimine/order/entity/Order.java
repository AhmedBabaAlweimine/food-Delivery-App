package com.alweimine.order.entity;

import com.alweimine.order.dto.FoodItemDto;
import com.alweimine.order.dto.Restaurant;
import com.alweimine.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemList;
    private Restaurant restaurant;
    private UserDto userDto;

}
