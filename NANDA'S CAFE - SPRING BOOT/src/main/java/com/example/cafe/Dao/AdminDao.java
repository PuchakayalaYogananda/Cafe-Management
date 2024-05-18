package com.example.cafe.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.Entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	
	 Admin findAdminByAdminName(String adminName);

}
