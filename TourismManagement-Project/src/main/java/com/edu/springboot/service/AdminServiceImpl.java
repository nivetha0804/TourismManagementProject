package com.edu.springboot.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.springboot.entity.Admin;
import com.edu.springboot.error.AdminNotFoundException;
import com.edu.springboot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	AdminRepository adminRepo;
	// insert the record	
	@Override
	public Admin saveAdmin(Admin admin) 
	{

		return adminRepo.save(admin) ;
	}
	// display the all record
	@Override
	public List<Admin> fetchAdminList() 
	{
		return adminRepo.findAll();
	}
	// display particular id	
	@Override
	public Admin fetchAdminById(Long adminId) throws AdminNotFoundException 
	{
		Optional<Admin> admin1= adminRepo.findById(adminId);//check in database
		if(!admin1.isPresent())
		{
			throw new AdminNotFoundException("Admin not available");
		}
		return adminRepo.findById(adminId).get() ;
	}
	// delete the record	
	@Override
	public void deleteAdminById(Long adminId) throws AdminNotFoundException 
	{
		Optional<Admin> admin1= adminRepo.findById(adminId);//check in database
		if(!admin1.isPresent()) 
		{
			throw new AdminNotFoundException("Admin not available");
		}
		else 
		{
			adminRepo.deleteById(adminId);
		}
	}
	//update the record	
	@Override
	public Admin updateAdmin(Long adminId, Admin admin) throws AdminNotFoundException
	{
		Optional<Admin> admin1= adminRepo.findById(adminId);//check id
		Admin admDB=null;
		if(admin1.isPresent()) 
		{
			//id
			admDB=	adminRepo.findById(adminId).get();
			//Name
			if(Objects.nonNull(admin.getAdminName()) && !"".equalsIgnoreCase(admin.getAdminName())) {
				admDB.setAdminName(admin.getAdminName());
			}
			//Password
			if(Objects.nonNull(admin.getAdminPassword()) && !"".equalsIgnoreCase(admin.getAdminPassword())) {
				admDB.setAdminPassword(admin.getAdminPassword());
				System.out.println(admin.getAdminPassword());
			}
			//EmailId
			if(Objects.nonNull(admin.getAdminEmailId()) && !"".equalsIgnoreCase(admin.getAdminEmailId())) {
				admDB.setAdminEmailId(admin.getAdminEmailId());
				System.out.println(admin.getAdminEmailId());
			}
			//AccomodationType
			if(Objects.nonNull(admin.getAdminAccomodationType()) && !"".equalsIgnoreCase(admin.getAdminAccomodationType())) {
				admDB.setAdminAccomodationType(admin.getAdminAccomodationType());
				System.out.println(admin.getAdminAccomodationType());
			}
			//Package
			if(Objects.nonNull(admin.getAdminPackage()) && !"".equals(admin.getAdminPackage())) {
				admDB.setAdminPackage(admin.getAdminPackage());
				System.out.println(admin.getAdminPackage());
			}
			//RoomType
			if(Objects.nonNull(admin.getAdminRoomType()) && !"".equalsIgnoreCase(admin.getAdminRoomType())) {
				admDB.setAdminRoomType(admin.getAdminRoomType());
				System.out.println(admin.getAdminRoomType());
			}
			return adminRepo.save(admDB);
		}//if
		else 
		{
			throw new AdminNotFoundException("Admin Not available");
		}
	}//update
	//get the name
	@Override
	public Admin fetchAdminByName(String adminName) 
	{
		return  adminRepo.findByAdminName(adminName);
	}
	// password
	@Override
	public Admin fetchAdminByPassword(String adminPassword) 
	{
		return  adminRepo.findByAdminPassword(adminPassword);
	}
	//Emailid	
	@Override
	public Admin fetchAdminByEmailId(String adminEmailId) 
	{
		return adminRepo.findByAdminEmailId(adminEmailId) ;
	}
	//AccomodationType	
	@Override
	public Admin fetchAdminByAccomodationType(String adminAccomodationType)
	{
		return adminRepo.findByAdminAccomodationType(adminAccomodationType);
	}
	//Package	
	@Override
	public Admin fetchAdminByPackage(Float adminPackage)
	{
		return adminRepo.findByAdminPackage(adminPackage);
	}
	// RoomType	
	@Override
	public Admin fetchAdminByRoomType(String adminRoomType) 
	{
		return adminRepo.findByAdminRoomType(adminRoomType) ;
	}	
}

