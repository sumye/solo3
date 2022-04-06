package com.sparta.solo3.controller;

import com.sparta.solo3.dto.RestaurantsDto;
import com.sparta.solo3.model.Restaurants;
import com.sparta.solo3.repository.RestaurantsRepository;
import com.sparta.solo3.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sparta.solo3.Validation.RestaurantValidation;

import java.util.List;

@RequiredArgsConstructor
@RestController


public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    @PostMapping("/restaurant/register")
    public Restaurants createRestaurants(@RequestBody RestaurantsDto restaurantsDto){
        return restaurantsService.createRestaurants(restaurantsDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurants> showRestaurants(){
        return restaurantsService.showRestaurants();
    }

}
