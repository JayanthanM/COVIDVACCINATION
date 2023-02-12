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

import com.cvm.entity.Certification;
import com.cvm.exception.CertificatesIdNotFoundException;
import com.cvm.service.CertificationService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class CertificationController {

	@Autowired
	CertificationService cs;

	@Operation( summary = "Add Certificate for Employee" )
	@PostMapping("/certificates")
	public ResponseEntity<String> addCertificate(@RequestBody Certification certificates) {
		String msg = cs.insertCertificate(certificates);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}

//	@GetMapping("/certificates")
//	public List<Certification> fetchAllCertificates() throws NoCertificatesFoundException {
//		return cs.findAll();
//	}

	@Operation(summary = "Get Certificate")
	@GetMapping("/certificates/{certificateId}")
	public ResponseEntity<Certification> fetchCertificateById(@PathVariable("certificateId") long certificateId)
			throws CertificatesIdNotFoundException {
		Certification msg = cs.findBycertificateId(certificateId);
		ResponseEntity<Certification> rEntity = new ResponseEntity<Certification>(msg, HttpStatus.FOUND);
		return rEntity;
	}


}
