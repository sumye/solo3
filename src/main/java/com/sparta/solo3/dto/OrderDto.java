package com.sparta.solo3.dto;

import com.sparta.solo3.model.FoodOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrder> foods;
    private int deliveryFee;
    private int totalPrice;
}
