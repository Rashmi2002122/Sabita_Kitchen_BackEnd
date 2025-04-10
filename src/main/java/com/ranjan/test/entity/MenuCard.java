package com.ranjan.test.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection  = "foodmenu")
public class MenuCard {
	
	@Id
	private String foodId;
	
	private String  foodName;
	
	private String  foodCatogories;

	private String foodDescription;
	
	private String foodImage;
	
	private List<String> foodItems;
	
	private String foodPrice;

	public MenuCard() {
		super();
		
	}

	public MenuCard(String foodName, String foodCatogories, String foodDescription, String foodImage,
			List<String> foodItems, String foodPrice) {
		super();
		this.foodName = foodName;
		this.foodCatogories = foodCatogories;
		this.foodDescription = foodDescription;
		this.foodImage = foodImage;
		this.foodItems = foodItems;
		this.foodPrice = foodPrice;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodCatogories() {
		return foodCatogories;
	}

	public void setFoodCatogories(String foodCatogories) {
		this.foodCatogories = foodCatogories;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public List<String> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<String> foodItems) {
		this.foodItems = foodItems;
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

	
	
	
	
	
	
	

}
