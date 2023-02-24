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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.MedicalStaff;
import com.cvm.exception.MedicalStaffIdNotFoundException;
import com.cvm.exception.NoMedicalStaffFoundException;
import com.cvm.service.MedicalStaffService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/staffs")
public class MedicalStaffController {

	@Autowired
	MedicalStaffService mss;

//	@Operation(summary = "Register Staff")
//	@PostMapping("/staffs")
//	public ResponseEntity<String> addMedicalStaff( @Valid @RequestBody MedicalStaff staff) {
//		String msg = mss.insertMedicalStaff(staff);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

	@Operation(summary = "Get All MedicalStaff Details")
	@GetMapping
	public List<MedicalStaff> fetchAllMedicalStaffs() throws NoMedicalStaffFoundException {
		return mss.findAll();
	}

	@Operation(summary = "Get MedicalStaff Details by Id")
	@GetMapping("/{staffId}")
	public ResponseEntity<MedicalStaff> findMedicalStaffById(@PathVariable("staffId") long staffId)
			throws MedicalStaffIdNotFoundException {
		MedicalStaff msg = mss.findByMedicalStaffId(staffId);
		ResponseEntity<MedicalStaff> rEntity = new ResponseEntity<MedicalStaff>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@Operation(summary = "modify the staff details by Id")
	@PutMapping("/{staffId}")
	public String modifyMedicalStaff( @PathVariable("staffId") long staffId,@Valid @RequestBody MedicalStaff staffs)
			throws MedicalStaffIdNotFoundException {
		return mss.updateMedicalStaff(staffId, staffs);
	}

	@Operation(summary = "delete medical staff by Id")
	@DeleteMapping("/{staffId}")
	public ResponseEntity<String> deleteMedicalStaffById(@PathVariable("staffId") long staffId)
			throws MedicalStaffIdNotFoundException {
		String msg = mss.deleteById(staffId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}
}