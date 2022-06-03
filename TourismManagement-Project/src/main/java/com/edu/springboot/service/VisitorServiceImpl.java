package com.edu.springboot.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.springboot.entity.Visitor;
import com.edu.springboot.error.VisitorNotFoundException;
import com.edu.springboot.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements VisitorService 
{
	@Autowired
	VisitorRepository visitorRepo;
	// insert the record	
	@Override
	public Visitor saveVisitor(Visitor visitor) 
	{
		return visitorRepo.save(visitor) ;
	}
	//display the all record	
	@Override
	public List<Visitor> fetchVisitorList() 
	{
		return visitorRepo.findAll();
	}
	// display the Id
	@Override
	public Visitor fetchVisitorById(Long visitorId) throws VisitorNotFoundException 
	{
		Optional<Visitor> visitor1= visitorRepo.findById(visitorId);//check in database
		if(!visitor1.isPresent()) {
			throw new VisitorNotFoundException("Visitor not available");
		}
		return visitorRepo.findById(visitorId).get() ;
	}
	// delete the record	
	@Override
	public void deleteVisitorById(Long visitorId) throws VisitorNotFoundException 
	{
		Optional<Visitor> visitor1= visitorRepo.findById(visitorId);//check in database
		if(!visitor1.isPresent()) 
		{
			throw new VisitorNotFoundException("Visitor not available");
		}
		else
		{
			visitorRepo.deleteById(visitorId);
		}	
	}
	// update the record
	@Override
	public Visitor updateVisitor(Long visitorId, Visitor visitor) throws VisitorNotFoundException 
	{
		Optional<Visitor> visitor1= visitorRepo.findById(visitorId);//check id
		Visitor visDB=null;
		if(visitor1.isPresent()) 
		{
			// id
			visDB=	visitorRepo.findById(visitorId).get();
			//Name
			if(Objects.nonNull(visitor.getVisitorName()) && !"".equalsIgnoreCase(visitor.getVisitorName())) {
				visDB.setVisitorName(visitor.getVisitorName());
			}
			// MobileNumber
			if(Objects.nonNull(visitor.getVisitorMobileNumber()) && !"".equalsIgnoreCase(visitor.getVisitorMobileNumber())) {
				visDB.setVisitorMobileNumber(visitor.getVisitorMobileNumber());
				System.out.println(visitor.getVisitorMobileNumber());
			}
			//MailId
			if(Objects.nonNull(visitor.getVisitorEmailId()) && !"".equalsIgnoreCase(visitor.getVisitorEmailId())) {
				visDB.setVisitorEmailId(visitor.getVisitorEmailId());
				System.out.println(visitor.getVisitorEmailId());
			}
			//Address
			if(Objects.nonNull(visitor.getVisitorAddress()) && !"".equalsIgnoreCase(visitor.getVisitorAddress())) {
				visDB.setVisitorAddress(visitor.getVisitorAddress());
				System.out.println(visitor.getVisitorAddress());
			}
			//Destination
			if(Objects.nonNull(visitor.getVisitorDestination()) && !"".equalsIgnoreCase(visitor.getVisitorDestination())) {
				visDB.setVisitorDestination(visitor.getVisitorDestination());
				System.out.println(visitor.getVisitorDestination());
			}
			return visitorRepo.save(visDB) ;
		}//if
		else 
		{
			throw new VisitorNotFoundException("Visitor Not available");
		}
	}//update	
	//visitor name	
	@Override
	public Visitor fetchVisitorByName(String visitorName) 
	{
		return visitorRepo.findByVisitorName(visitorName);
	}
	// visitor MobileNumber	
	@Override
	public Visitor fetchVisitorByMobileNumber(String visitorMobileNumber) 
	{
		return visitorRepo.findByVisitorMobileNumber(visitorMobileNumber);
	}
	// visitor Emailid	
	@Override
	public Visitor fetchVisitorByEmailId(String visitorEmailId) 
	{
		return visitorRepo.findByVisitorEmailId(visitorEmailId);
	}
	// visitor Address	
	@Override
	public Visitor fetchVisitorByAddress(String visitorAddress) 
	{
		return visitorRepo.findByVisitorAddress(visitorAddress) ;
	}
	// visitor destination	
	@Override
	public Visitor fetchVisitorByDestination(String visitorDestination)
	{
		return visitorRepo.findByVisitorDestination(visitorDestination);
	}
}


