package com.sparta.solo3.service;

import com.sparta.solo3.dto.RestaurantsDto;
import com.sparta.solo3.model.Restaurants;
import com.sparta.solo3.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    public Restaurants createRestaurants(RestaurantsDto restaurantsDto) {
        if(restaurantsDto.getMinOrderPrice() < 1000 || restaurantsDto.getMinOrderPrice() > 100000) throw new IllegalArgumentException("주문금액 범위를 확인하세요.");
        if(restaurantsDto.getMinOrderPrice() % 100 != 0) throw new IllegalArgumentException("단위를 확인하세요.");
        if(restaurantsDto.getDeliveryFee() < 0 || restaurantsDto.getDeliveryFee() > 10000) throw new IllegalArgumentException("배달비 범위를 확인하세요.");
        if(restaurantsDto.getDeliveryFee() % 500 != 0) throw new IllegalArgumentException("단위를 확인하세요.");
        Restaurants restaurants = new Restaurants(restaurantsDto);
        return restaurantsRepository.save(restaurants);
    }

    public List<Restaurants> showRestaurants() {
        return restaurantsRepository.findAll();
    }


}