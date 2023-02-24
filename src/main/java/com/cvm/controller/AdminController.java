package com.cvm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.Admin;
import com.cvm.exception.AdminsIdNotFoundException;
import com.cvm.exception.NoAdminsFoundException;
import com.cvm.service.AdminServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class AdminController {
	@Autowired
	AdminServices as;
	
	@Operation(summary = "Get All Admin Details")
	@GetMapping("/admins")
	public List<Admin> fetchAllAdmins() throws NoAdminsFoundException {
	return as.findAll();
	}
	
	@Operation(summary = "Get All Admin Details by Id")
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<Admin> fetchAdminById(@PathVariable("adminId") long adminId) throws AdminsIdNotFoundException {
	Admin msg = as.findByAdminId(adminId);
	ResponseEntity<Admin> rEntity = new ResponseEntity<Admin>(msg, HttpStatus.FOUND);
	return rEntity;
	}
	
	@Operation(summary = "Update Admin Details by Id")
	@PutMapping("/admins/{adminId}")
	public String modifyAdmin(@PathVariable("adminId") long adminId, @Valid @RequestBody Admin admin)throws AdminsIdNotFoundException {
	return as.updateAdmin(adminId, admin);
	}
}
