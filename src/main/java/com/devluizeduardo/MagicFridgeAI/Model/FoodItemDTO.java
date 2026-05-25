package com.devluizeduardo.MagicFridgeAI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodItemDTO {
    private Long id;
    private String nome;
    private FoodCategoria categoria;
    private Integer quantidade;
    private LocalDate validade;
}
