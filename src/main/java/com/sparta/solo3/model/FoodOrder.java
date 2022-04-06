package com.sparta.solo3.model;


import com.sparta.solo3.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Ordercase ordercase;

    public FoodOrder(FoodOrderDto foodOrderDto){
        this.name = foodOrderDto.getName();
        this.quantity = foodOrderDto.getQuantity();
        this.price = foodOrderDto.getPrice();
    }
}