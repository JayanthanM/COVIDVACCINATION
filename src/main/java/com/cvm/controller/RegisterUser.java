package com.cvm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.Admin;
import com.cvm.entity.Employees;
import com.cvm.entity.MedicalStaff;
import com.cvm.service.RegisterUserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/covid/")
public class RegisterUser {

	@Autowired
	RegisterUserService rs;
	
	@Operation(summary = "Admin SignUp")
	@PostMapping("/admins")
	public ResponseEntity<String> addAdmin( @Valid @RequestBody Admin admin) {
		String msg = rs.insertAdmin(admin);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "Employee SignUp")
	@PostMapping("/employees")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employees emp) {
		String msg = rs.insertEmployee(emp);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
	
	@Operation(summary = "MedicalStaff SignUp")
	@PostMapping("/staffs")
	public ResponseEntity<String> addMedicalStaff(@Valid @RequestBody MedicalStaff staff) {
		String msg = rs.insertMedicalStaff(staff);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}
}
