package com.sparta.solo3.repository;

import com.sparta.solo3.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
    Restaurants findRestaurantsById(Long Id);

}