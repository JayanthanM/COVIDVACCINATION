package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvm.entity.VitalsAtVaccination;
import com.cvm.exception.NoVitalsFoundException;
import com.cvm.exception.VitalIdNotFoundException;
import com.cvm.dao.VitalsAtVaccinationDao;

@Service("vs")
public class VitalsAtVaccinationService {
	@Autowired
     VitalsAtVaccinationDao vt;

	public String insertVitals(VitalsAtVaccination vvn) {
		VitalsAtVaccination vaVvn = vt.save(vvn);
		return "Added Successfully with ID :" + vaVvn.getVitalId();
	}

	public List<VitalsAtVaccination> findAll() throws NoVitalsFoundException {
		List<VitalsAtVaccination> list = vt.findAll();
		if (list.isEmpty()) {
			throw new NoVitalsFoundException("No Vitals Found");
		}
		return list;
	}
	
	public VitalsAtVaccination findByVitalId(long id) throws VitalIdNotFoundException {
		Optional<VitalsAtVaccination> op = vt.findById(id);
		if (op.isPresent()) {
			return op.get();
		} 
		else {
			throw new VitalIdNotFoundException("Id not Found :" + id);
		}
	}
}