package com.edu.springboot.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(generator="seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=1001)
	private Long adminId;
	@NotNull(message="Admin cannot be null")
	@NotBlank(message="Admin name cannot be blank")
	private String adminName;
	@Length(min=4, max=10, message="Password cannot be less than 4 characters")
	private String adminPassword;
	@Email
	private String adminEmailId;
	@Length(min=3, message="AccomodationType cannot be less than 3 characters")
	private String adminAccomodationType;
	private Float adminPackage;
	private String adminRoomType;
	@OneToMany(targetEntity=Visitor.class,cascade=CascadeType.ALL)
	@JoinColumn(name="adminId")
	private List<Visitor> visitors;
	// generate the getter and setter method	
	public Long getAdminId() 
	{
		return adminId;
	}
	public void setAdminId(Long adminId)
	{
		this.adminId = adminId;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	public String getAdminPassword()
	{
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) 
	{
		this.adminPassword = adminPassword;
	}
	public String getAdminEmailId() 
	{
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) 
	{
		this.adminEmailId = adminEmailId;
	}
	public String getAdminAccomodationType() 
	{
		return adminAccomodationType;
	}
	public void setAdminAccomodationType(String adminAccomodationType) 
	{
		this.adminAccomodationType = adminAccomodationType;
	}
	public Float getAdminPackage()
	{
		return adminPackage;
	}
	public void setAdminPackage(Float adminPackage)
	{
		this.adminPackage = adminPackage;
	}
	public String getAdminRoomType()
	{
		return adminRoomType;
	}
	public void setAdminRoomType(String adminRoomType) 
	{
		this.adminRoomType = adminRoomType;
	}
	public List<Visitor> getVisitors(){
		return visitors;
	}
	public void setVisitors(List<Visitor> visitors) 
	{
		this.visitors = visitors;
	}
	// generate the to string	
	@Override
	public String toString() 
	{
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminEmailId=" + adminEmailId + ", adminAccomodationType=" + adminAccomodationType
				+ ", adminPackage=" + adminPackage + ", adminRoomType=" + adminRoomType + ", visitors=" + visitors
				+ "]";
	}
	// generate the constructor field(within the argument)	
	public Admin(Long adminId,
			@NotNull(message = "Admin cannot be null") @NotBlank(message = "Admin name cannot be blank") String adminName,
			@Length(min = 4, max = 10, message = "Password cannot be less than 4 characters") String adminPassword,
			@Email String adminEmailId,
			@Length(min = 3, message = "AccomodationType cannot be less than 3 characters") String adminAccomodationType,
			Float adminPackage, String adminRoomType, List<Visitor> visitors) 
	{
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminEmailId = adminEmailId;
		this.adminAccomodationType = adminAccomodationType;
		this.adminPackage = adminPackage;
		this.adminRoomType = adminRoomType;
		this.visitors = visitors;
	}
	// generate the constructor superclass(without the argument)	
	public Admin() 
	{
		super();

	}
}