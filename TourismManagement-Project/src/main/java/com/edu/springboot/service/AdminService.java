package com.edu.springboot.service;

import java.util.List;
import com.edu.springboot.entity.Admin;
import com.edu.springboot.error.AdminNotFoundException;

public interface AdminService 
{
	Admin saveAdmin(Admin admin);
	List<Admin> fetchAdminList();
	Admin fetchAdminById(Long adminId) throws AdminNotFoundException;
	void deleteAdminById(Long adminId) throws AdminNotFoundException;
	Admin updateAdmin(Long adminId, Admin admin) throws AdminNotFoundException;
	Admin fetchAdminByName(String adminName);
	Admin fetchAdminByPassword(String adminPassword);
	Admin fetchAdminByEmailId(String adminEmailId);
	Admin fetchAdminByAccomodationType(String adminAccomodationType);
	Admin fetchAdminByPackage(Float adminPackage);
	Admin fetchAdminByRoomType(String adminRoomType);
}