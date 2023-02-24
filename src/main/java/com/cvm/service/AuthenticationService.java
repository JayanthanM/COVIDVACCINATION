package com.cvm.service;

import com.cvm.entity.Admin;
import com.cvm.entity.Employees;
import com.cvm.entity.MedicalStaff;
import com.cvm.exception.EmailIdNotFoundException;

public interface AuthenticationService {
	public Employees loginemployee(String mobileNo,String password);
	public Admin loginadmin(String emailId , String password) throws EmailIdNotFoundException ;
	public MedicalStaff loginstaff(String emailId , String password) throws EmailIdNotFoundException;
}