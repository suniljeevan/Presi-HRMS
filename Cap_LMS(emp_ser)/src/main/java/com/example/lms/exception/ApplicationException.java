package com.example.lms.exception;


public class ApplicationException extends RuntimeException {
	
	
	public ApplicationException(Long id )
	{
		 super("Leave Not foung: "+id);
	}

}
