package com.cvm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cvm.entity.Slot;
import com.cvm.exception.IdNotMatchException;
import com.cvm.exception.NoSlotFoundException;
import com.cvm.exception.SlotIdNotFoundException;
import com.cvm.dao.SlotDao;
import com.cvm.service.SlotService;

@SpringBootTest
public class SlotServiceTest {
	
	@InjectMocks
	SlotService slotService;

	@Mock
	SlotDao slotDao;
	
	List<Slot> list = new ArrayList<>();
	Slot slot = new Slot();

	@Test
	public void testInsertSlot() {
		slot.setSlotId(1);
		slot.setSlotDate(LocalDate.of(2023, 06, 10));
		slot.setSlotLocation("Chennai");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(20);
		
		when(slotDao.save(slot)).thenReturn(slot);
		String result = slotService.insertSlot(slot);
		assertEquals("Slot Added Successfully"+slot.getSlotId(), result);
	}

	
	@Test
	public void testFindAll() throws NoSlotFoundException {
		slot.setSlotId(1);
		slot.setSlotDate(LocalDate.of(2023, 06, 10));
		slot.setSlotLocation("Chennai");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(20);
		list.add(slot);
		when(slotDao.findAll()).thenReturn(list);
		List<Slot> result = new ArrayList<>();
		result = slotService.findAll();
		assertEquals(list ,result);;
	}

	@Test
	public void testFindBySlotId() throws SlotIdNotFoundException {
		
		int id = 2;
		slot.setSlotId(2);
		slot.setSlotDate(LocalDate.of(2023, 07, 10));
		slot.setSlotLocation("Madras");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(10);
		
		 Optional<Slot> op = Optional.of(slot);
		 when(slotDao.existsById(slot.getSlotId())).thenReturn(true);
		 when(slotDao.findById(slot.getSlotId())).thenReturn(op);
		 Optional<Slot> result  = Optional.of(slotService.findBySlotId(slot.getSlotId()));
		 assertEquals(op, result);
	}

	@Test
	public void testUpdateSlot() throws IdNotMatchException {
		
		int id = 2;
		slot.setSlotId(2);
		slot.setSlotDate(LocalDate.of(2023, 07, 10));
		slot.setSlotLocation("Madras");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(10);
		
		when(slotDao.existsById(slot.getSlotId())).thenReturn(true);
		when(slotDao.save(slot)).thenReturn(slot);
		String result = slotService.updateSlot(id,slot);
		assertEquals("Updated Successfully for id:"+slot.getSlotId(),result);
	}

	@Test
	public void testDeleteSlotById() throws NoSlotFoundException {
		
		int id = 2;
		slot.setSlotId(2);
		slot.setSlotDate(LocalDate.of(2023, 07, 10));
		slot.setSlotLocation("Madras");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(10);
		
		when(slotDao.existsById(slot.getSlotId())).thenReturn(true);
		String result = slotService.deleteSlotById(slot.getSlotId());
		assertEquals("Deleted Successfully for id:"+slot.getSlotId(), result);
		}
	
	@Test
	public void testFindSlotByLocation() throws NoSlotFoundException 
	{ 
		String location = "Madras";
		slot.setSlotId(2);
		slot.setSlotDate(LocalDate.of(2023, 07, 10));
		slot.setSlotLocation("Madras");
		slot.setCurrentSlots(30);
		slot.setBalanceSlots(10);
		
		Optional<Slot> op = Optional.of(slot);
		when(slotDao.findSlotBySlotLocation(location)).thenReturn(op);
		Slot result = slotService.findSlotByLocation(location);
		Optional<Slot> actual = Optional.of(result);
		assertEquals(slot,result);
		
	}
}