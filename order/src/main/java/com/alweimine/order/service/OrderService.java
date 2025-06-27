package com.alweimine.order.service;

import com.alweimine.order.dto.OrderDto;
import com.alweimine.order.dto.OrderDtoFromFE;
import com.alweimine.order.dto.UserDto;
import com.alweimine.order.entity.Order;
import com.alweimine.order.mapper.OrderMapper;
import com.alweimine.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private RestTemplate restTemplate;

    public OrderDto saveOrder(OrderDtoFromFE orderDtoFromFE) {
        Integer newOrderID = sequenceGenerator.generateNextOderId();
        UserDto userDetails = fetchUserDetailsFromUserId(orderDtoFromFE.getUserId());
        Order order = new Order(newOrderID, orderDtoFromFE.getFoodItemsList(), orderDtoFromFE.getRestaurant(), userDetails);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderRepo.save(order));
    }

    private UserDto fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/" + userId, UserDto.class);
    }
}
