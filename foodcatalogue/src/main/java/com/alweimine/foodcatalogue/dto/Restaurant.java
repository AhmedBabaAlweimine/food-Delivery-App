package com.alweimine.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    private int id;
    private String name;
    private String adress;
    private String city;
    private String description;
}
