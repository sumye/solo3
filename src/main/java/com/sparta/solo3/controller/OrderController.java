package com.sparta.solo3.controller;


import com.sparta.solo3.dto.OrderRequestDto;
import com.sparta.solo3.model.Ordercase;
import com.sparta.solo3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public Ordercase createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<Ordercase> showOrder() {

        return orderService.showOrder();
    }


}