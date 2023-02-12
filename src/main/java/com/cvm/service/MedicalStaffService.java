package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.MedicalStaffDao;
import com.cvm.entity.MedicalStaff;
import com.cvm.exception.MedicalStaffIdNotFoundException;
import com.cvm.exception.NoMedicalStaffFoundException;


@Service("mss")
public class MedicalStaffService {
	@Autowired
	MedicalStaffDao msd;

	public String insertMedicalStaff(MedicalStaff staffs) {
		//staffs.setStaffToVitals(staffs.getVitals());
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(staffs.getPassword());
		staffs.setPassword(encryptedPwd);
		MedicalStaff dbStaff = msd.save(staffs);
		return "Added Successfully with staffId:" + dbStaff.getStaffId();
	}

	public List<MedicalStaff> findAll() throws NoMedicalStaffFoundException {
		List<MedicalStaff> list= msd.findAll();
		if(list.isEmpty()) {
			throw new NoMedicalStaffFoundException("No Medical Staff found");
			
		}
		return list;
	}

	public MedicalStaff findByMedicalStaffId(long staffId) throws MedicalStaffIdNotFoundException {
		Optional<MedicalStaff> op = msd.findById(staffId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new MedicalStaffIdNotFoundException("MedicalStaff Not Found For staffId:"+staffId);
		}
	}

	public String updateMedicalStaff(long staffId, MedicalStaff staffs) throws MedicalStaffIdNotFoundException {
		if (staffId == staffs.getStaffId()) {
			MedicalStaff upStaff = msd.save(staffs);
			return "Updated Successfully for staffId:" + upStaff.getStaffId();
		}
		//return "staffID must be same in path Variable and in the request body";
		throw new MedicalStaffIdNotFoundException("MedicalStaff Not Found For staffId:"+staffId);
	}

	public String deleteById(long staffId) throws MedicalStaffIdNotFoundException {
		if (msd.existsById(staffId)) {
			msd.deleteById(staffId);
			return "Deleted Successfully for StaffId:" + staffId;
		}
		throw new MedicalStaffIdNotFoundException("MedicalStaff Not Found For staffId:"+staffId);
	}

}
