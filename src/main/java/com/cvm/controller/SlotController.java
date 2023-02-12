package com.cvm.controller;

import java.util.List;
import java.util.Optional;

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

import com.cvm.entity.Slot;
import com.cvm.exception.IdNotMatchException;
import com.cvm.exception.NoSlotFoundException;
import com.cvm.exception.SlotIdNotFoundException;
import com.cvm.service.SlotService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SlotController {
	@Autowired
	SlotService slotservice;

	@Operation(summary = "Add Slots")
	@PostMapping(value = "/slots")
	public ResponseEntity<String> addSlot(@Valid @RequestBody Slot slot) {
		// slot.setSlottoVitals(slot.getVitals());
		String msg = slotservice.insertSlot(slot);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return rEntity;
	}

	@Operation(summary = "Get slot details by Location")
	@GetMapping("/slots/byLocation/{slotLocation}")
	public ResponseEntity<Slot> findSlotByLocation(@PathVariable("slotLocation") String location)
			throws NoSlotFoundException {
		Slot msg = slotservice.findSlotByLocation(location);
		ResponseEntity<Slot> rEntity = new ResponseEntity<Slot>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@Operation(summary = "Get All Slots")
	@GetMapping(value = "/slots")
	public List<Slot> fetchAllSlots() throws NoSlotFoundException {
		return slotservice.findAll();
	}

	@Operation(summary = "Get Slot Details by Id")
	@GetMapping("/slots/{id}")
	public ResponseEntity<Slot> findSlotById(@PathVariable("id") int id)
			throws SlotIdNotFoundException, IdNotMatchException, NoSlotFoundException {
		Slot slot = slotservice.findBySlotId(id);
		ResponseEntity<Slot> rEntity = new ResponseEntity<Slot>(slot, HttpStatus.FOUND);
		return rEntity;
	}

	@Operation(summary = "Update Slot Details by Id")
	@PutMapping("/slots/{id}")
	public ResponseEntity<String> modifySlot(@PathVariable("id") int id, @Valid @RequestBody Slot slot)
			throws SlotIdNotFoundException, IdNotMatchException {
		String msg = slotservice.updateSlot(id, slot);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
		return rEntity;
	}

	@Operation(summary = "Delete Slots")
	@DeleteMapping("/slots/{id}")
	public ResponseEntity<String> deleteSlotById(@PathVariable("id") int id) throws NoSlotFoundException {
		String msg = slotservice.deleteSlotById(id);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}

}
