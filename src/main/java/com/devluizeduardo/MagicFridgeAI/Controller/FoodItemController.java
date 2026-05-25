package com.devluizeduardo.MagicFridgeAI.Controller;

import com.devluizeduardo.MagicFridgeAI.Model.FoodItem;
import com.devluizeduardo.MagicFridgeAI.Model.FoodItemDTO;
import com.devluizeduardo.MagicFridgeAI.Service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody FoodItemDTO foodItemDTO){

        FoodItemDTO novo = foodItemService.criar(foodItemDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novo.getNome()+"Salvo com sucesso!!!");

    }


    @GetMapping("/listar")
    public ResponseEntity<List<FoodItemDTO>> listarItens(){
        List<FoodItemDTO> lista = foodItemService.listarItens();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarItemPorId(@PathVariable Long id){

        FoodItemDTO foodItemDTO = foodItemService.listarItemPorId(id);
        if(foodItemDTO!=null){
            return ResponseEntity.ok(foodItemDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item nao encontrado");
        }
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<?> atualizarItem(@PathVariable Long id,@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO itemAtualizado = foodItemService.atualizarItem(id,foodItemDTO);
        if(itemAtualizado!=null){
            return ResponseEntity.ok(itemAtualizado.getNome()+"Atualizado com sucesso!!!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item nao encontrado!!!");
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarItem(Long id){
        if(foodItemService.listarItemPorId(id)!=null){
            foodItemService.deletarItem(id);
            return ResponseEntity.ok("Item deletado com sucesso!!!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item nao encontrado!!!");
        }
    }



}
