package com.cvm.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.AdminDao;
import com.cvm.dao.EmployeesDao;
import com.cvm.dao.MedicalStaffDao;
import com.cvm.entity.Admin;
import com.cvm.entity.Employees;
import com.cvm.entity.MedicalStaff;
import com.cvm.exception.EmailIdNotFoundException;
import com.cvm.exception.EmployeeAuthenticationFailureException;
import com.cvm.exception.EmployeeMobileNoNotExistingException;


@Service("employeeAuthenticationService")
public class EmployeeAuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	EmployeesDao employeeRepository;
	
	public Employees loginemployee(String mobileNo, String password)
	{
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional<Employees> optionalEmployee = employeeRepository.findByMobileNo(mobileNo);
		
		if(optionalEmployee.isEmpty())
		{
			throw new EmployeeMobileNoNotExistingException("Employee Not registred");
		}
		Employees employee = optionalEmployee.get();
		if(bcrypt.matches(password,employee.getPassword()))
		{
			System.out.println("hello");
			return employee;
		}
		throw new EmployeeAuthenticationFailureException("Employee is not authenticated") ;
	}
	
	@Autowired
	AdminDao ad;
	
	BCryptPasswordEncoder bcrypt1 = new BCryptPasswordEncoder();
	public Admin loginadmin(String emailId, String password) throws EmailIdNotFoundException {
		Optional<Admin> opa= ad.findByEmailId(emailId);
		if(opa.isEmpty()) {
			throw new EmailIdNotFoundException("EmailId not registered");
		}
		Admin admin=opa.get();
		if(bcrypt1.matches(password,admin.getPassword())){
			 return admin;
		}
		throw new EmailIdNotFoundException("Enter Valid Password");
	}
	
	@Autowired
	MedicalStaffDao msd;
	
	BCryptPasswordEncoder bcrypt2 = new BCryptPasswordEncoder();
	public MedicalStaff loginstaff(String emailId, String password) throws EmailIdNotFoundException {
		Optional<MedicalStaff> opm= msd.findByEmailId(emailId);
		if(opm.isEmpty()) {
			throw new EmailIdNotFoundException("EmailId not registered");
		}
		MedicalStaff staff=opm.get();
		if(bcrypt2.matches(password,staff.getPassword())){
			 return staff;
		}
		throw new EmailIdNotFoundException("Enter Valid Password");
	}
	
}
