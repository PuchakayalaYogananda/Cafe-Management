package com.example.cafe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.Dao.FoodDao;
import com.example.cafe.Entity.Food;
import com.example.cafe.Exception.FoodNotFoundException;

@Service
public class FoodServiceImpl implements FoodService{
	
		@Autowired
	    private FoodDao  foodDao;

		@Override
		public List<Food> findAll() {
			return foodDao.findAll();
		}

		@Override
		public void save(Food p) {
			foodDao.save(p);
			
		}

		@Override
		public Optional<Food> findById(Long id) {
			return foodDao.findById(id);
		}

		@Override
		public void updateproduct(Food p) {
			
			foodDao.save(p);
			
		}

		@Override
		public void deleteById(Long id) {
			foodDao.deleteById(id);
			
		}

		@Override
		public List<Food> findByFoodname(String foodName) {
			return this.foodDao.findByFoodName(foodName);
		}

		

		@Override
		public Optional<Food> getUserByFoodId(long foodId) {
			 Optional<Food> Item = foodDao.findById(foodId);
			 if (Item.isEmpty()) {
			        throw new FoodNotFoundException(foodId);
			    }
			    return Item;
		}

		@Override
		public List<Food> findByfoodName(String foodName) {
			return foodDao.findByfoodNameIgnoreCase(foodName);
		}

		@Override
		public Optional<Food> getFoodByname(Long pid) {
			return Optional.empty();
		}

	

		

}
