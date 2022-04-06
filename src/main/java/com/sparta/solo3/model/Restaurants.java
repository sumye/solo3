package com.sparta.solo3.model;

import com.sparta.solo3.dto.RestaurantsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor



public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int minOrderPrice;

    @Column
    private int deliveryFee;


    // 음식점 생성
    public Restaurants(RestaurantsDto restaurantsDto){
        this.name = restaurantsDto.getName();
        this.minOrderPrice = restaurantsDto.getMinOrderPrice();
        this.deliveryFee = restaurantsDto.getDeliveryFee();
    }







}
