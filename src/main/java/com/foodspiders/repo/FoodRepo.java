package com.foodspiders.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodspiders.model.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
