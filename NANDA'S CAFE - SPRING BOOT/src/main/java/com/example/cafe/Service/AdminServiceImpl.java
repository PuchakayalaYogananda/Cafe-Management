package com.example.cafe.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.Dao.AdminDao;
import com.example.cafe.Entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	public AdminDao adminDao;

	@Override
	public List<Admin> findAll() {
		
		return adminDao.findAll();
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.adminDao.save(admin);
	}

	@Override
	public Admin findByUsername(String username) {
		
		return adminDao.findAdminByAdminName(username);
	}
//
//	@Override
//	public void deleteById(int id) {
//		
//		adminDao.deleteById(id);
//	}

	@Override
	public Optional<Admin> findById(int id) {
		
		return Optional.empty();
	}

	@Override
	public void addAdmin(Admin admin) {
		this.adminDao.save(admin);
		
	}

}
