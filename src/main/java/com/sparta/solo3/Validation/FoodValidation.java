package com.sparta.solo3.Validation;


import com.sparta.solo3.dto.FoodDto;
import com.sparta.solo3.model.Food;
import org.springframework.stereotype.Component;

@Component


public class FoodValidation {

    public static final int MinimumFoodPrice = 100;
    public static final int MaximumFoodPrice = 1000000;
    public static final int FoodPriceUnit = 100;



    public static void food(Food food) {
        if (food.getPrice() < MinimumFoodPrice || food.getPrice() > MaximumFoodPrice)
            throw new IllegalArgumentException("가격 범위를 확인하세요");
        if (food.getPrice() % FoodPriceUnit != 0)
            throw new IllegalArgumentException("가격 단위를 확인하세요");
    }




}
