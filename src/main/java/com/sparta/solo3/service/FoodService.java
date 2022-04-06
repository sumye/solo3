package com.sparta.solo3.service;

import com.sparta.solo3.dto.FoodDto;
import com.sparta.solo3.model.Food;
import com.sparta.solo3.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {


    private final FoodRepository foodRepository;


    @Transactional
    public void createFood(Long restaurantId, List<FoodDto> foodDtoList) {
        HashSet<String> foods= new HashSet<>();
        for(FoodDto food : foodDtoList){
            foods.add(food.getName());
        }
        if(foods.size() != foodDtoList.size()) throw new IllegalArgumentException("같은메뉴를 추가할수 없습니다.");
        if(exsistMenu(foodDtoList, restaurantId)) throw new IllegalArgumentException("이미 등록된 메뉴가 있습니다.");

        for(FoodDto menu : foodDtoList){
            Food food = new Food(menu, restaurantId);
            if(food.getPrice() < 100 || food.getPrice() > 1000000) throw new IllegalArgumentException("가격 범위를 확인하세요.");
            if(food.getPrice() % 100 != 0) throw new IllegalArgumentException("단위를 확인하세요.");
            foodRepository.save(food);
        }
    }

    @Transactional
    public List<Food> showFood(Long restaurantId) {
        return foodRepository.findAllByRestaurantsId(restaurantId);
    }

    public boolean exsistMenu(List<FoodDto> newMenu, Long restaurantId){
        for (FoodDto newFood : newMenu) {
            if (foodRepository.existsByNameAndRestaurantsId(newFood.getName(), restaurantId))
                return true;
        }
        return false;

    }
}