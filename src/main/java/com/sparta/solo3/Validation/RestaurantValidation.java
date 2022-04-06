package com.sparta.solo3.Validation;

import com.sparta.solo3.dto.RestaurantsDto;
import org.springframework.stereotype.Component;

@Component

public class RestaurantValidation {

    public static final int MinimumOrderPrice = 1000;
    public static final int MaximumOrderPrice = 100000;
    public static final int minOrderPriceUnit = 100;
    public static final int MinimumDeliveryFee = 0;
    public static final int MaximumDeliveryFee = 10000;
    public static final int deliveryFeeUnit = 500;


    public static void restaurant(RestaurantsDto restaurantDto) {
        if(restaurantDto.getMinOrderPrice() < MinimumOrderPrice || restaurantDto.getMinOrderPrice() > MaximumOrderPrice)
            throw new IllegalArgumentException("최소주문 가격 범위를 확인하세요");
        if(restaurantDto.getMinOrderPrice() % minOrderPriceUnit != 0)
            throw new IllegalArgumentException("최저 주문 금액 단위를 확인하세요");
        if(restaurantDto.getDeliveryFee() < MinimumDeliveryFee || restaurantDto.getDeliveryFee() > MaximumDeliveryFee)
            throw new IllegalArgumentException("배달비 범위를 확인하세요");
        if(restaurantDto.getDeliveryFee() % deliveryFeeUnit != 0)
            throw new IllegalArgumentException("배달비 단위를 확인하세요");
    }









}
