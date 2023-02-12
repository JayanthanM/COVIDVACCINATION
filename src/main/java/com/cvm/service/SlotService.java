package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvm.entity.Slot;
import com.cvm.exception.IdNotMatchException;
import com.cvm.exception.NoSlotFoundException;
import com.cvm.exception.SlotIdNotFoundException;
import com.cvm.dao.SlotDao;

@Service("slotservice")
public class SlotService {

	@Autowired
	SlotDao slotdao;

	public String insertSlot(Slot s) {
		Slot slot = slotdao.save(s);
		return "Slot Added Successfully" + slot.getSlotId();
	}

	public List<Slot> findAll() throws NoSlotFoundException {
		List<Slot> list = slotdao.findAll();
		if (list.isEmpty()) {
			throw new NoSlotFoundException("No Slot Found");
		}
		return list;
	}

	public Slot findSlotByLocation(String location) throws NoSlotFoundException {
		Optional<Slot> op= slotdao.findSlotBySlotLocation(location);
		if(op.isPresent())
			return op.get();
		else
			throw new NoSlotFoundException("Slot Not Found for Location:"+location);
	}

	public Slot findBySlotId(int id) throws SlotIdNotFoundException {
		Optional<Slot> op = slotdao.findById(id);
		if (op.isEmpty())
			throw new SlotIdNotFoundException("Slot is Not Existing" + id);
		return op.get();
	}

	public String updateSlot(int id, Slot slot) throws IdNotMatchException {
		if (id == slot.getSlotId()) {
			if (slotdao.existsById(id)) {
				Slot upSlot = slotdao.save(slot);
				return "Updated Successfully for id:" + upSlot.getSlotId();
			}
		}
		throw new IdNotMatchException("Id is not matched");
	}
	
	public String deleteSlotById(int id) throws NoSlotFoundException {
		if (slotdao.existsById(id)) {
			slotdao.deleteById(id);
			return "Deleted Successfully for id:" + id;
		}
		return "Record Not Found For Id:" + id;
	}
}