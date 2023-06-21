package com.foodspiders.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodspiders.model.Food;
import com.foodspiders.service.FoodService;

@Controller
@CrossOrigin
@RequestMapping("food")
public class FoodController {
	@Autowired
	private FoodService foodserv;
	
	@RequestMapping("/welcome")
	public ResponseEntity<String> welcome()
	{
		return ResponseEntity.status(200).body("It is working");
	}
	
	@GetMapping("/readall")
	public ResponseEntity<List<Food>> readall()
	{
		List<Food> allfood=foodserv.readrall();
		if(allfood!=null)
		{
			return ResponseEntity.status(200).body(allfood);
		}
		else
		{
			return ResponseEntity.status(400).body(allfood);
		}
		
	}
	
	@GetMapping("/readone/{id}")
	public ResponseEntity<Optional<Food>> readone(@PathVariable int id)
	{
		Optional<Food> f1=foodserv.readone(id);
		if(f1!=null)
		{
			return ResponseEntity.status(200).body(f1);
		}
		else
		{
			return ResponseEntity.status(400).body(f1);
		}
		
	}
	
	@RequestMapping("/save")
	public ResponseEntity <String> savefood(@RequestBody Food f1)
	{
		String food=foodserv.save(f1);
		if(food!=null)
		{
			return ResponseEntity.ok(food);
		}
		else
		{
			return ResponseEntity.status(400).body("not working");
		}
	}
	
	@RequestMapping("update")
	public ResponseEntity <String>update(@RequestHeader int id,@RequestBody Food f1)
	{
		String s1= foodserv.updatefood(id, f1);
		if(s1!=null)
		{
			return ResponseEntity.status(200).body(s1);
		}
		else
		{
			return ResponseEntity.status(400).body(s1);
		}
	}
}
