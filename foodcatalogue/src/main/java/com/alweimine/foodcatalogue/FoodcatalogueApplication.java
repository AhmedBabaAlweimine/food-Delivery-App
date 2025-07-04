package com.alweimine.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodcatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcatalogueApplication.class, args);
	}

	@Bean
	@LoadBalanced   //to make the call of services balanced with eureka server
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
