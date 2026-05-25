package com.devluizeduardo.MagicFridgeAI.Service;

import com.devluizeduardo.MagicFridgeAI.Model.FoodItem;
import com.devluizeduardo.MagicFridgeAI.Model.FoodItemDTO;
import com.devluizeduardo.MagicFridgeAI.Model.FoodItemMapper;
import com.devluizeduardo.MagicFridgeAI.Repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    public final FoodItemRepository foodItemRepository;
    public final FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO criar(FoodItemDTO foodItemDTO){
        FoodItem foodItem = foodItemMapper.map(foodItemDTO);
        FoodItem salvo =foodItemRepository.save(foodItem);

        return foodItemMapper.map(salvo);

    }


    public List<FoodItemDTO> listarItens(){

        List<FoodItem> listaItens = foodItemRepository.findAll();

        return listaItens.stream()
                .map(foodItemMapper::map)
                .collect(Collectors.toList());
    }

    public FoodItemDTO listarItemPorId(Long id){
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        return foodItem.map(foodItemMapper::map).orElse(null);
    }

    public FoodItemDTO atualizarItem(Long id,FoodItemDTO foodItemDTO){
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);

        if(foodItem.isPresent()){
            FoodItem atualizado = foodItemMapper.map(foodItemDTO);
            atualizado.setId(id);
            FoodItem salvo = foodItemRepository.save(atualizado);
            return foodItemMapper.map(salvo);

        }
        return null;
    }

    public void deletarItem(Long id){
        foodItemRepository.deleteById(id);
    }
}
