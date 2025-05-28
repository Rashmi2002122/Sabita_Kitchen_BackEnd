package com.ranjan.test.mainController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjan.test.entity.MenuCard;
import com.ranjan.test.services.MenuServcies;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/getmenu")
@CrossOrigin(origins = {"https://cloud-kitchen-6803.onrender.com", "http://localhost:3000"})
public class MenuController {

	@Autowired
	private MenuServcies menuServcies;

	@GetMapping("/")
	public List<MenuCard> getAllMenu() {
		List<MenuCard> allFood = menuServcies.getAllFood();
		return allFood;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getFood(@PathVariable("id") String id) {
		Optional<MenuCard> foodById = menuServcies.getFoodById(id);
		if (foodById.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(foodById);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{foodCatogories}")
	public ResponseEntity<Object> getFoodCatogories(@PathVariable("foodCatogories") String str) {

		
		List<MenuCard> list = menuServcies.findBycato(str);
		if(list!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping("/addFood")
	public ResponseEntity<Object> addFood(@RequestBody MenuCard card) {

		MenuCard food = menuServcies.addFood(card);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(food);

	}

	@PostMapping("/addAllFood")
	public List<MenuCard> postMethodName(@RequestBody List<MenuCard> todaysMenu) {

		List<MenuCard> food = menuServcies.addAllFood(todaysMenu);

		return food;
	}

}
