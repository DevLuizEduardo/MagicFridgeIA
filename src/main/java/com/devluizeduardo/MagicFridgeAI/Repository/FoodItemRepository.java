package com.devluizeduardo.MagicFridgeAI.Repository;

import com.devluizeduardo.MagicFridgeAI.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
