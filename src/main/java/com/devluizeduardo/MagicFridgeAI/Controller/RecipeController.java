package com.devluizeduardo.MagicFridgeAI.Controller;

import com.devluizeduardo.MagicFridgeAI.Model.FoodItemDTO;
import com.devluizeduardo.MagicFridgeAI.Service.FoodItemService;
import com.devluizeduardo.MagicFridgeAI.Service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private final GeminiService geminiService;
    private final FoodItemService foodItemService;

    public RecipeController(GeminiService geminiService, FoodItemService foodItemService) {
        this.geminiService = geminiService;
        this.foodItemService = foodItemService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generatRecipe(){
        List<FoodItemDTO> foodItems = foodItemService.listarItens();
     return geminiService.generateRecipe(foodItems)
             .map(recipe->ResponseEntity.ok(recipe))
             .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
