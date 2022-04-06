package com.sparta.solo3.service;


import com.sparta.solo3.dto.FoodOrderDto;
import com.sparta.solo3.dto.FoodOrderRequestDto;
import com.sparta.solo3.dto.OrderRequestDto;
import com.sparta.solo3.model.FoodOrder;
import com.sparta.solo3.model.Ordercase;
import com.sparta.solo3.repository.FoodOrderRepository;
import com.sparta.solo3.repository.FoodRepository;
import com.sparta.solo3.repository.OrderRepository;
import com.sparta.solo3.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;

    public Ordercase createOrder(OrderRequestDto requestDto) {
        int howmanyOrder = requestDto.getFoods().size();
        int quantity = 0;
        int totalPrice = 0;
        int price = 0;

        List<FoodOrder> foodOrders = new ArrayList<>();
        Long restaurantId = requestDto.getRestaurantId();
        String restaurantName = restaurantsRepository.findRestaurantsById(restaurantId).getName();
        int deliveryFee = restaurantsRepository.findRestaurantsById(restaurantId).getDeliveryFee();

        for(int i = 0; i < howmanyOrder; i++){
            FoodOrderRequestDto foodOrderRequestDto = requestDto.getFoods().get(i);
            quantity = foodOrderRequestDto.getQuantity();
            price = foodRepository.findByIdAndRestaurantsId(foodOrderRequestDto.getId(), restaurantId).getPrice();
            if(quantity < 1 || quantity >100) throw new IllegalArgumentException("주문 수량 범위를 확인하세요.");
            String foodName = foodRepository.findByIdAndRestaurantsId(foodOrderRequestDto.getId(), restaurantId).getName();
            FoodOrderDto foodOrderDto = new FoodOrderDto();
            foodOrderDto.setName(foodName);
            foodOrderDto.setQuantity(quantity);
            foodOrderDto.setPrice(price * quantity);
            totalPrice += quantity * price;
            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            foodOrderRepository.save(foodOrder);
            foodOrders.add(foodOrder);
        }
//
        if(totalPrice < restaurantsRepository.findRestaurantsById(restaurantId).getMinOrderPrice()) throw new IllegalArgumentException("최소주문금액을 확인해하세요.");
        totalPrice += deliveryFee;
        Ordercase ordercase = new Ordercase(restaurantName, foodOrders, deliveryFee, totalPrice);
        orderRepository.save(ordercase);
        return ordercase;

    }

    public List<Ordercase> showOrder() {
        return orderRepository.findAll();
    }
}