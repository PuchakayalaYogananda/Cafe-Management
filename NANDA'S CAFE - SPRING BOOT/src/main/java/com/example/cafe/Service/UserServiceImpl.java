package com.example.cafe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.Dao.UserDao;
import com.example.cafe.Entity.User;



@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	public UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.save(user);
		
	}
	@Override
	public List<User> findAll() {
	
		return userDao.findAll();
	}

	@Override
	public void DeletebyId(long userId) {
		
		
		userDao.deleteById(userId);
		
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	public Optional<User> getUserByName(Long uid) {
		
		return Optional.empty();
	}

	@Override
	public Optional<User> findByUserId(long userId) {
		
		return Optional.empty();
	}

	@Override
	public void updateUser(User user) {
	
		userDao.save(user);
	}
	@Override
	public Optional<User> getUserByname(Long uid) {
		return Optional.empty();
	}
	@Override
	public Optional<User> findUserById(Long uid) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
