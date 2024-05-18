package com.example.cafe.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.Dao.FoodDao;
import com.example.cafe.Entity.Food;
import com.example.cafe.Service.FoodService;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin("http://localhost:4200")
public class FoodController {
	
	@Autowired
	FoodDao foodDao;

    @Autowired
    private FoodService foodService;

    @PostMapping("/addfood")
	public ResponseEntity<Map<String,String>>saveproduct(@RequestBody Food p)
	{
		try
		{
			Optional<Food>existingproduct=this.foodDao.findById(p.getFoodId());
			if(existingproduct.isEmpty())
			{
				this.foodService.save(p);
				Map<String,String>response=new HashMap<String,String>();
				response.put("status", "success");
	            response.put("message", "Product data added!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
	         }
			else
			{
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Product already  found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e1)
		{
			Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Product not updated!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
    @PutMapping("/update")
	public ResponseEntity<Map<String,String>> updateproduct(@RequestBody Food p)
	{
		try
		{
			if(this.foodDao.findById(p.getFoodId()).isPresent())
			{
				Food existingProduct=this.foodDao.findById(p.getFoodId()).get();
				existingProduct.setFoodName(p.getFoodName());
				
				this.foodService.updateproduct(p);
				Map<String,String> response=new HashMap<String,String>();
	            response.put("status", "success");
	            response.put("message", "Product data updated!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
	            }
	            else
	            {
	                Map<String,String> response=new HashMap<String,String>();
	                response.put("status", "failed");
	                response.put("message", "Product data  not found!!");
	                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
	            }
			}
			 catch(Exception e1)
		        {
		            Map<String,String> response=new HashMap<String,String>();
		            response.put("status", "failed");
		            response.put("message", "Product not updated!!");
		            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		        }
	}
    

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,String>> deleteById(@PathVariable Long id)
	{
		try
		{
			this.foodService.deleteById(id);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Product data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Product data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	 @GetMapping("/foodName/{foodName}")
	    public ResponseEntity<List<Food>> getMenuByFname(@PathVariable String foodName) {
	        System.out.println("Received a request to get menu items by fname: " + foodName);

	        List<Food> menuItems = foodService.findByfoodName(foodName);

	        if (menuItems.isEmpty()) {
	            System.out.println("No menu items found for fname: " + foodName);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        System.out.println("Returning menu items by fname: " + menuItems);
	        return new ResponseEntity<>(menuItems, HttpStatus.OK);
	    }
	 
	 @GetMapping("/all")
	 public ResponseEntity<List<Food>> getAllFoods() {
	     try {
	         List<Food> foods = foodService.findAll();
	         if (foods.isEmpty()) {
	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	         }
	         return new ResponseEntity<>(foods, HttpStatus.OK);
	     } catch (Exception e) {
	         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }

	
    
}