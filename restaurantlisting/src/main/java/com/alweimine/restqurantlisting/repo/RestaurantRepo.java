package com.alweimine.restqurantlisting.repo;

import com.alweimine.restqurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,  Integer> {
}
