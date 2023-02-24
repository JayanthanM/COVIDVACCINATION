package com.cvm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cvm.dao.VitalsAtVaccinationDao;
import com.cvm.entity.VitalsAtVaccination;
import com.cvm.exception.NoVitalsFoundException;
import com.cvm.exception.VitalIdNotFoundException;
import com.cvm.service.VitalsAtVaccinationService;

@SpringBootTest
public class VitalsAtVaccinationServiceTest {
	@InjectMocks
	VitalsAtVaccinationService vs;
	
	@Mock
	VitalsAtVaccinationDao vd;
	List<VitalsAtVaccination> list = new ArrayList<>();
	VitalsAtVaccination vv = new VitalsAtVaccination();

	@Test
 public void testInsertVitals() 
 {
	 vv.setVitalId(1);
	 vv.setVitalTemperature(97);
	 vv.setVitalSaturation(60);
	 vv.setVitalBloodPressure(111);
	 vv.setVitalTime("10pm");
	 when(vd.save(vv)).thenReturn(vv);
	 String result = vs.insertVitals(vv);
	 assertEquals("Added Successfully with ID :"+vv.getVitalId(),result);
}

	@Test
	public void testFindAll() throws NoVitalsFoundException {
		 vv.setVitalId(1);
		 vv.setVitalTemperature(97);
		 vv.setVitalSaturation(60);
		 vv.setVitalBloodPressure(111);
		 vv.setVitalTime("10pm");
		list.add(vv);
		when(vd.findAll()).thenReturn(list);
		List<VitalsAtVaccination> result = new ArrayList<>();
		result = vs.findAll();
		assertEquals(list,result);
	}

	@Test
	public void testfindByVitalId() throws VitalIdNotFoundException {
		int id = 2;
		vv.setVitalId(2);
		 vv.setVitalTemperature(97);
		 vv.setVitalSaturation(60);
		 vv.setVitalBloodPressure(111);
		 vv.setVitalTime("10pm");
		Optional<VitalsAtVaccination> op = Optional.of(vv);
		when(vd.existsById(vv.getVitalId())).thenReturn(true);
		when(vd.findById(vv.getVitalId())).thenReturn(op);
		Optional<VitalsAtVaccination> result = Optional.of(vs.findByVitalId(vv.getVitalId()));
		assertEquals(op, result);
	}
}