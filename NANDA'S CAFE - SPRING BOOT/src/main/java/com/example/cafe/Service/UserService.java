package com.example.cafe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.cafe.Entity.User;

@Service
public interface UserService {
	
	public void addUser(User user);
	
	public List<User> findAll();
	
	public void DeletebyId(long userId);
	
	public User findByUsername(String username);
	
	public Optional<User> getUserByname(Long uid);
	
	public Optional<User> findByUserId(long userId);

	void updateUser(User user);

	Optional<User> getUserByName(Long uid);

	public Optional<User> findUserById(Long uid);

}
