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

import com.example.cafe.Dao.UserDao;
import com.example.cafe.Entity.User;
import com.example.cafe.Service.EmailService;
import com.example.cafe.Service.UserService;
import com.example.cafe.Exception.UserNotFoundException;

	
	
	
	@RestController
	@RequestMapping("/api/users")
	@CrossOrigin("http://localhost:4200")
	public class UserController {
		
		@Autowired
		UserDao userDao;
		
		@Autowired
		private EmailService emailService;
	
	    @Autowired
	    private UserService userService;
	
	    @PostMapping("/register")
		public ResponseEntity<Map<String, String>> singup(@RequestBody User user) {
			this.userService.addUser(user);
			Map<String, String> response = new HashMap<String, String>();
			response.put("status", "success");
			response.put("message", "User registered!!");
			emailService.sendEmail(user.getUserEmail(), user.getUsername(), user.getUserPassword());
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
		}

	    @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody User user) {
	        User existingUser = userService.findByUsername(user.getUsername());
	        if(existingUser.getUserPassword().equals(user.getUserPassword())) {
	        	User sendcustomer = new User();
	        	sendcustomer.setUserId(existingUser.getUserId());
	        	sendcustomer.setUserContact(existingUser.getUserContact());
	        	sendcustomer.setUsername(existingUser.getUsername());
	        	sendcustomer.setUserPassword(existingUser.getUserPassword());
	        	sendcustomer.setUserEmail(existingUser.getUserEmail());
	        	
	        	return ResponseEntity.ok(sendcustomer);
	        } else {
	        	return (ResponseEntity<?>) ResponseEntity.internalServerError();
	        }
	    }

	
	    @GetMapping("/all")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.findAll();
	        return ResponseEntity.ok(users);
	    }
	    @GetMapping("/id/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable long id) {
	        Optional<User> userOptional = userDao.findById(id);

	        if (userOptional.isPresent()) {
	            return ResponseEntity.ok(userOptional.get());
	        } else {
	            throw new UserNotFoundException("User with ID " + id + " not found.");
	        }
	    }
	    @PutMapping("/update")
		public ResponseEntity<Map<String, String>> updateUser(@RequestBody User user) {
			try {
				if (this.userDao.findById(user.getUserId()).isPresent()) {
					User existingCus = this.userDao.findById(user.getUserId()).get();
					existingCus.setUsername(user.getUsername());
					existingCus.setUserContact(user.getUserContact());
					existingCus.setUsername(user.getUsername());
					existingCus.setUserPassword(user.getUserPassword());
					existingCus.setUserEmail(user.getUserEmail());
					this.userDao.save(existingCus);

					Map<String, String> response = new HashMap<String, String>();
					response.put("status", "success");
					response.put("message", "User data updated!!");
					return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
				} else {
					Map<String, String> response = new HashMap<String, String>();
					response.put("status", "failed");
					response.put("message", "User data not found!!");
					return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e1) {
				Map<String, String> response = new HashMap<String, String>();
				response.put("status", "failed");
				response.put("message", "User data not updated!!");
				return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
			}
		}

	
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUserById(@PathVariable("id") long id) {
	        userService.DeletebyId(id);
	        return ResponseEntity.ok("User deleted successfully");
	    }
	
	    @GetMapping("/username/{username}")
	    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
	        User user = userService.findByUsername(username);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}
