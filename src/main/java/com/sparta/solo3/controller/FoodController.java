package com.sparta.solo3.controller;

import com.sparta.solo3.dto.FoodDto;
import com.sparta.solo3.model.Food;
import com.sparta.solo3.service.FoodService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
public class FoodController {


    private final FoodService foodService;


    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.createFood(restaurantId, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showFood(@PathVariable Long restaurantId){
        return foodService.showFood(restaurantId);
    }
}