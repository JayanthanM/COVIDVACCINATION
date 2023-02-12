package com.cvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.Employees;
import com.cvm.entity.LoginReq;
import com.cvm.service.EmployeeAuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth")
public class EmployeeAuthenticationController {

	
//	@Autowired
//	EmployeeAuthenticationService employeeAuthenticationService;
//	
//	@Operation(summary = "Employee Login")
//	@PostMapping("/login")
//	public ResponseEntity<Employees> doLogin(@RequestBody LoginReq loginReq)  
//	{
//		Employees employee = employeeAuthenticationService.login(loginReq.getMobileNo(), loginReq.getPassword());
//		ResponseEntity<Employees> responseEntity = new ResponseEntity<>(employee,HttpStatus.OK);
//		return responseEntity;
//	}
	
	
}