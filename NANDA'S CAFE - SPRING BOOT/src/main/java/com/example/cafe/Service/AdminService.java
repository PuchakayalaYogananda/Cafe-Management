package com.example.cafe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cafe.Entity.Admin;

@Service
public interface AdminService {
	
	public List<Admin> findAll();
	public void updateAdmin(Admin admin);
	Admin findByUsername(String username);
//	public void deleteById(int id);
	public Optional<Admin>findById(int id);
	public void addAdmin(Admin admin);

}
