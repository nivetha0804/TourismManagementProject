package com.edu.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.edu.springboot.entity.Admin;
import com.edu.springboot.error.AdminNotFoundException;
import com.edu.springboot.service.AdminService;

@RestController
public class AdminController 
{
	@Autowired
	AdminService adminService;
	// insert
	@PostMapping("/admins/")
	public Admin saveAdmin(@RequestBody Admin admin) 
	{
		return adminService.saveAdmin(admin);
	}
	//get Records
	@GetMapping("/admins/")
	public List<Admin> fetchAdminList()
	{
		return adminService.fetchAdminList();
	}
	//get the record by Id
	@GetMapping("/admins/{adminId}")
	public Admin fetchAdminById(@PathVariable("adminId") Long adminId) throws AdminNotFoundException  
	{
		return adminService.fetchAdminById(adminId);
	}
	//delete Records
	@DeleteMapping("/admins/{adminId}")
	public String deleteAdminById(@PathVariable("adminId") Long adminId) throws AdminNotFoundException 
	{
		adminService.deleteAdminById(adminId);
		return "Admin is deleted";	
	}
	//update Records
	@PutMapping("/admins/{adminId}")
	public Admin updateAdmin(@PathVariable ("adminId") Long adminId, @RequestBody Admin admin) throws AdminNotFoundException 
	{
		return adminService.updateAdmin(adminId,admin);
	}
	// get the name record	
	@GetMapping("/admins/name/{adminName}")
	public Admin fetchAdminByName(@PathVariable("adminName") String adminName)
	{
		return adminService.fetchAdminByName(adminName);
	}	
	// get the password record
	@GetMapping("/admins/password/{adminPassword}")
	public Admin fetchAdminByPassword(@PathVariable("adminPassword") String adminPassword)
	{
		return adminService.fetchAdminByPassword(adminPassword);
	}	
	// get the	email id record
	@GetMapping("/admins/emailid/{adminEmailId}")
	public Admin fetchAdminByEmailid(@PathVariable("adminEmailId") String adminEmailId)
	{
		return adminService.fetchAdminByEmailId(adminEmailId);
	}	
	// get the accomodationtype
	@GetMapping("/admins/accomodationtype/{adminAccomodationType}")
	public Admin fetchAdminByAccomodationType(@PathVariable("adminAccomodationType") String adminAccomodationType)
	{
		return adminService.fetchAdminByAccomodationType(adminAccomodationType);
	}	
	// get the package record
	@GetMapping("/admins/package/{adminPackage}")
	public Admin fetchAdminByPackage(@PathVariable("adminPackage") Float adminPackage)
	{
		return adminService.fetchAdminByPackage(adminPackage);
	}	
	// get the room type
	@GetMapping("/admins/roomtype/{adminRoomType}")
	public Admin fetchAdminByRoomType(@PathVariable("adminRoomType") String adminRoomType)
	{
		return adminService.fetchAdminByRoomType(adminRoomType);
	}	
}
