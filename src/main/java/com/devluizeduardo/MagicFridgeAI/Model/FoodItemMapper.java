package com.devluizeduardo.MagicFridgeAI.Model;

import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {
    public FoodItem map(FoodItemDTO foodItemDTO){
        FoodItem foodItem = new FoodItem();
        foodItem.setNome(foodItemDTO.getNome());
        foodItem.setCategoria(foodItemDTO.getCategoria());
        foodItem.setQuantidade(foodItemDTO.getQuantidade());
        foodItem.setValidade(foodItemDTO.getValidade());

        return foodItem;

    }


    public FoodItemDTO map(FoodItem foodItem){
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setNome(foodItem.getNome());
        foodItemDTO.setCategoria(foodItem.getCategoria());
        foodItemDTO.setQuantidade(foodItem.getQuantidade());
        foodItemDTO.setValidade(foodItem.getValidade());

        return foodItemDTO;

    }
}
