package com.edu.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Visitor 
{
	@Id
	@GeneratedValue
	private Long visitorId;
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Visitor name cannot be blank")
	private String visitorName;
	@Length(min=10, max=13, message="Mobile number cannot be less than 10 characters")
	private String visitorMobileNumber;
	@Email
	private String visitorEmailId;
	@Length(min=3, message="Address cannot be less than 3 characters")
	private String visitorAddress;
	@NotNull(message="Destination  cannot be null")
	@NotBlank(message="Visitor Destination name cannot be blank")
	private String visitorDestination;
	// generate the setter and getter method	
	public Long getVisitorId() 
	{
		return visitorId;
	}
	public void setVisitorId(Long visitorId)
	{
		this.visitorId = visitorId;
	}
	public String getVisitorName() 
	{
		return visitorName;
	}
	public void setVisitorName(String visitorName) 
	{
		this.visitorName = visitorName;
	}
	public String getVisitorMobileNumber() 
	{
		return visitorMobileNumber;
	}
	public void setVisitorMobileNumber(String visitorMobileNumber)
	{
		this.visitorMobileNumber = visitorMobileNumber;
	}
	public String getVisitorEmailId() 
	{
		return visitorEmailId;
	}
	public void setVisitorEmailId(String visitorEmailId)
	{
		this.visitorEmailId = visitorEmailId;
	}
	public String getVisitorAddress()
	{
		return visitorAddress;
	}
	public void setVisitorAddress(String visitorAddress)
	{
		this.visitorAddress = visitorAddress;
	}
	public String getVisitorDestination() 
	{
		return visitorDestination;
	}
	public void setVisitorDestination(String visitorDestination) 
	{
		this.visitorDestination = visitorDestination;
	}
	// generate the to string	
	@Override
	public String toString() 
	{
		return "Visitor [visitorId=" + visitorId + ", visitorName=" + visitorName + ", visitorMobileNumber="
				+ visitorMobileNumber + ", visitorEmailId=" + visitorEmailId + ", visitorAddress=" + visitorAddress
				+ ", visitorDestination=" + visitorDestination + "]";
	}
	// generate the constructor field(within the argument)	
	public Visitor(Long visitorId,
			@NotNull(message = "Name cannot be null") @NotBlank(message = "Visitor name cannot be blank") String visitorName,
			@Length(min = 10, max = 13, message = "Mobile number cannot be less than 10 characters") String visitorMobileNumber,
			@Email String visitorEmailId,
			@Length(min = 3, message = "Address cannot be less than 3 characters") String visitorAddress,
			@NotNull(message = "Destination  cannot be null") @NotBlank(message = "Visitor Destination name cannot be blank") String visitorDestination)
	{
		super();
		this.visitorId = visitorId;
		this.visitorName = visitorName;
		this.visitorMobileNumber = visitorMobileNumber;
		this.visitorEmailId = visitorEmailId;
		this.visitorAddress = visitorAddress;
		this.visitorDestination = visitorDestination;
	}	
	// generate the constructor superclass(without the argument)	
	public Visitor() 
	{
		super();	
	}
}

