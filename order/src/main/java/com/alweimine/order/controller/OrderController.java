package com.alweimine.order.controller;

import com.alweimine.order.dto.OrderDto;
import com.alweimine.order.dto.OrderDtoFromFE;
import com.alweimine.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
        public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE  orderDtoFromFE){
         OrderDto ordeerSavedInDb=orderService.saveOrder(orderDtoFromFE);
         return ResponseEntity.ok(ordeerSavedInDb);
        }
}
