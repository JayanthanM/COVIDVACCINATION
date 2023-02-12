package com.cvm.controller;

import java.util.List;

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

import com.cvm.entity.Employees;
import com.cvm.exception.EmployeeIdNotFoundException;
import com.cvm.exception.NoEmployeesFoundException;
import com.cvm.service.EmployeesService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class EmployeesController {

	@Autowired
	EmployeesService es;

//	@Operation(summary = "Emplyee SignUp")
//	@PostMapping("/employees")
//	public ResponseEntity<String> addEmployee(@RequestBody Employees emp) {
//		String msg = es.insertEmployee(emp);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@Operation(summary = "Get All Employee Details")
	@GetMapping("/employees")
	public List<Employees> fetchAllEmployees() throws NoEmployeesFoundException {
		return es.findAll();
	}

	@Operation(summary = "Get Employee Details by Id")
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employees> findEmployeeById(@PathVariable("employeeId") long employeeId)throws EmployeeIdNotFoundException {
		Employees msg = es.findByEmployeeId(employeeId);
		ResponseEntity<Employees> rEntity = new ResponseEntity<Employees>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@Operation(summary = "Update Employee Details")
	@PutMapping("/employees/{employeeId}")
	public String modifyEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Employees emps)
			throws EmployeeIdNotFoundException {
		return es.updateEmployee(employeeId, emps);
	}

	@Operation(summary = "Delete Employee Details")
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<String> deleteTraineeById(@PathVariable("employeeId") long employeeId)
			throws EmployeeIdNotFoundException {
		String msg = es.deleteById(employeeId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}
}
