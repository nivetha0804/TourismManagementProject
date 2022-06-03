package com.edu.springboot.error;

public class VisitorNotFoundException extends Exception 
{
	private static final long serialversionUID=1L;
	public VisitorNotFoundException(String s)
	{
		super(s);
	}
}