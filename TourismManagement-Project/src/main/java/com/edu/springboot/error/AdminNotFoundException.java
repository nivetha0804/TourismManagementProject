package com.edu.springboot.error;

public class AdminNotFoundException extends Exception 
{
	private static final long serialversionUID=1L;
	public AdminNotFoundException(String s)
	{
		super(s);
	}
}
