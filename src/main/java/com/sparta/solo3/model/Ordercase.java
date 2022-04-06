package com.sparta.solo3.model;


import com.sparta.solo3.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Ordercase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String restaurantName;

    @OneToMany
    @JoinColumn
    private List<FoodOrder> foods;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    public Ordercase(String restaurantName, List<FoodOrder> foods, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

    public Ordercase(OrderDto orderDto){
        this.restaurantName = orderDto.getRestaurantName();
        this.foods = orderDto.getFoods();
        this.deliveryFee = orderDto.getDeliveryFee();
        this.totalPrice = orderDto.getTotalPrice();
    }
}