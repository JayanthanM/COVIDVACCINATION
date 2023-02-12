package com.cvm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvm.entity.VitalsAtVaccination;
import com.cvm.exception.NoVitalsFoundException;
import com.cvm.exception.VitalIdNotFoundException;
import com.cvm.service.VitalsAtVaccinationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class VitalsAtVaccinationController {
	
	@Autowired
	VitalsAtVaccinationService vs;
	
	@Operation(summary = "Add Vitals")
	@PostMapping(value="/vitals")
	public ResponseEntity<String> addVitals(@Valid @RequestBody VitalsAtVaccination vta)
	{
		String msg=vs.insertVitals(vta);
		ResponseEntity<String> vEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return vEntity;
	}
	
	@Operation(summary = "Get All Vital Details")
	@GetMapping(value="/vitals")
	public List<VitalsAtVaccination> fetchAllVitals() throws NoVitalsFoundException
	{
		return vs.findAll();
	}
	
	@Operation(summary = "Get Vital Details by Id")
	@GetMapping("/vitals/{vitalid}")
    public ResponseEntity<VitalsAtVaccination> findVitalsById(@PathVariable("vitalid") long vitalId) throws VitalIdNotFoundException
	{
		VitalsAtVaccination vitalatvaccination= vs.findByVitalId(vitalId);
		ResponseEntity<VitalsAtVaccination> vEntity = new ResponseEntity<VitalsAtVaccination>(vitalatvaccination, HttpStatus.FOUND);
		return vEntity;
	}
}