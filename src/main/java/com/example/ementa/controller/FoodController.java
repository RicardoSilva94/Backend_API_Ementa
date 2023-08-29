package com.example.ementa.controller;

import com.example.ementa.food.Food;
import com.example.ementa.food.FoodRepository;
import com.example.ementa.food.FoodRequestDTO;
import com.example.ementa.food.FoodResponseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")

public class FoodController {
@Autowired
    private FoodRepository repository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
    Food foodData = new Food(data);
    repository.save(foodData);
}
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;


    }
}