package com.cvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.Admin;
import com.cvm.entity.AdminAuthentication;
import com.cvm.entity.Employees;
import com.cvm.entity.EmployeesAuthentication;
import com.cvm.entity.MedicalStaff;
import com.cvm.entity.MedicalstaffAuthentication;
import com.cvm.exception.EmailIdNotFoundException;
import com.cvm.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/")
public class LoginUser {

	@Autowired
	AuthenticationService eas;
	
	@Operation(summary = "Employee Login")
	@PostMapping("/login/employees")
	public ResponseEntity<Employees> doLogin(@RequestBody EmployeesAuthentication emp) throws EmailIdNotFoundException {
		Employees msg = eas.loginemployee(emp.getMobileNo(), emp.getPassword());
		ResponseEntity<Employees> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	
	@Operation(summary = "Admin Login")
	@PostMapping("/login/admins")
	public ResponseEntity<Admin> doLoginAdmin(@RequestBody AdminAuthentication admin) throws EmailIdNotFoundException {
		Admin msg = eas.loginadmin(admin.getEmailId(), admin.getPassword());
		ResponseEntity<Admin> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	@Operation(summary = "Medical Staff Login")
	@PostMapping("/login/staffs")
	public ResponseEntity<MedicalStaff> doLoginStaff(@RequestBody MedicalstaffAuthentication staff) throws EmailIdNotFoundException {
		MedicalStaff msg = eas.loginstaff(staff.getEmailId(), staff.getPassword());
		ResponseEntity<MedicalStaff> rEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return rEntity;
	}
	

}