package com.sparta.solo3.model;

import com.sparta.solo3.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private Long restaurantsId;

    public Food(FoodDto foodDto, Long restaurantsId){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantsId = restaurantsId;
    }
}