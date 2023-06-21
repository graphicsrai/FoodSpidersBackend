package com.foodspiders.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodspiders.model.Food;
import com.foodspiders.repo.FoodRepo;

@Service
public class FoodService {
	@Autowired
	private FoodRepo foodrepo;
	
	public String save(Food f1)
	{
		foodrepo.save(f1);
		return "Food item has been saved";
	}

	public List<Food> readrall() {
		
		return foodrepo.findAll();
	}
	
	public String updatefood(int id,Food food)
	{		
			foodrepo.deleteById(id);
			foodrepo.save(food);
			return "Food hass been updated";
		
	}

	public Optional<Food> readone(int id) {
		
		return foodrepo.findById(id);
	}
}
