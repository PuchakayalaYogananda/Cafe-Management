package com.example.cafe.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cafe.Entity.Food;

@Repository
public interface FoodDao extends JpaRepository<Food, Long> {
	
	
	 List<Food> findByFoodName(String foodName);
	@Query(value = "SELECT * FROM Food_items pd WHERE pd.food_name = ?1",nativeQuery = true )
	public Optional<Food> findFoodName (String title);
	static Optional<Food> findById(long foodId){
		return null; 
	}
	List<Food>findByfoodNameIgnoreCase(String foodName);
	boolean existsByfoodName(String foodName);

}
