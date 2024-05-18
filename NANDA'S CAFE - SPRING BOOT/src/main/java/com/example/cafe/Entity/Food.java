package com.example.cafe.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="foodId")
	public long foodId; 
	
	public String foodName; 
	
	public double foodPrice; 
	
	public String foodImage; 
	
	public String foodDescription; 
	
	public Food() {
		
	}
	
	public Food(long foodId, String foodName, double foodPrice, String foodImage, String foodDescription) {
		
		super();
		
		this.foodId = foodId; 
		this.foodName = foodName; 
		this.foodDescription = foodDescription; 
		this.foodPrice = foodPrice; 
		this.foodImage = foodImage; 
		
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	
	
}
