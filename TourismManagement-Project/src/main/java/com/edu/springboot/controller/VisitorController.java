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
import com.edu.springboot.entity.Visitor;
import com.edu.springboot.error.VisitorNotFoundException;
import com.edu.springboot.service.VisitorService;

@RestController
public class VisitorController 
{
	@Autowired
	VisitorService visitorService;
// insert the record	
	@PostMapping("/visitors/")
	public Visitor saveVisitor(@RequestBody Visitor visitor) 
	{
		return visitorService.saveVisitor(visitor);
	}
// display the all record
	@GetMapping("/visitors/")
	public List<Visitor> fetchVisitorList()
	{
		return visitorService.fetchVisitorList();
	}
//display the particular id
	@GetMapping("/visitors/{visitorId}")
	public Visitor fetchVisitorById(@PathVariable("visitorId") Long visitorId) throws VisitorNotFoundException 
	{
		return visitorService.fetchVisitorById(visitorId);
	}	
// delete the record
	@DeleteMapping("/visitors/{visitorId}")
	public String deleteVisitorById(@PathVariable("visitorId") Long visitorId) throws VisitorNotFoundException 
	{
		visitorService.deleteVisitorById(visitorId);
		return "Visitor is deleted";	
	}	
//Update the record	
	@PutMapping("/visitors/{visitorId}")
	public Visitor updateVisitor(@PathVariable ("visitorId") Long visitorId, @RequestBody Visitor visitor) throws VisitorNotFoundException
	{
		return visitorService.updateVisitor(visitorId,visitor);
	}
//get name record		
	@GetMapping("/visitors/name/{visitorName}")
	public Visitor fetchVisitorByName(@PathVariable("visitorName") String visitorName)  
	{
	 return visitorService.fetchVisitorByName(visitorName);
     }
//get the Mobilenumber
	@GetMapping("/visitors/mobile/{visitorMobileNumber}")
public Visitor fetchVisitorByMobileNumber(@PathVariable("visitorMobileNumber") String visitorMobileNumber)  
	{
	 return visitorService.fetchVisitorByMobileNumber(visitorMobileNumber);
	 }	
// get the emailid
  @GetMapping("/visitors/emailid/{visitorEmailId}")
	public Visitor fetchVisitorByEmailId(@PathVariable("visitorEmailId") String visitorEmailId)  
	{
	 return visitorService.fetchVisitorByEmailId(visitorEmailId);
	 }	
// get the address
	@GetMapping("/visitors/address/{visitorAddress}")
	public Visitor fetchVisitorByAddress(@PathVariable("visitorAddress") String visitorAddress)  
     {
		return visitorService.fetchVisitorByAddress(visitorAddress);
		}
// get the destination
	@GetMapping("/visitors/destination/{visitorDestination}")
  public Visitor fetchVisitorByDestination(@PathVariable("visitorDestination") String visitorDestination)  
	{
	 return visitorService.fetchVisitorByDestination(visitorDestination);
	 }	
}

