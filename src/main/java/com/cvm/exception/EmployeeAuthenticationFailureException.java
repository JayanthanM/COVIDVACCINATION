package com.cvm.exception;

public class EmployeeAuthenticationFailureException extends RuntimeException{
	public EmployeeAuthenticationFailureException(String msg) {
		super(msg);
	}
}