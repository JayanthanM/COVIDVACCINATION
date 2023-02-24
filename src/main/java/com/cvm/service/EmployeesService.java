package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.EmployeesDao;
import com.cvm.entity.Employees;
import com.cvm.exception.EmployeeIdNotFoundException;
import com.cvm.exception.NoEmployeesFoundException;


@Service("es")
public class EmployeesService {

	@Autowired
	EmployeesDao ed;


	public String insertEmployee(Employees emp) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(emp.getPassword());
		emp.setPassword(encryptedPwd);
		Employees employee = ed.save(emp);
		return "Added Successfully with Id :" + employee.getEmpId();
	}

	public List<Employees> findAll() throws NoEmployeesFoundException {
		List<Employees> list = ed.findAll();
		if (list.isEmpty()) {
			throw new NoEmployeesFoundException("No Employee found");
		}
		return list;
	}

	public Employees findByEmployeeId(long employeeId) throws EmployeeIdNotFoundException {
		Optional<Employees> op = ed.findById(employeeId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new EmployeeIdNotFoundException("Employee Not Found For Id :" + employeeId);
		}
	}

	public String updateEmployee(long employeeId, Employees emps) throws EmployeeIdNotFoundException {
		if (employeeId == emps.getEmpId()) {
			Employees upTin = ed.save(emps);
			return "Updated Successfully for id:" + upTin.getEmpId();
		}
		throw new EmployeeIdNotFoundException("Employee Not Found For Id :" + employeeId);
	}

	public String deleteById(long employeeId) throws EmployeeIdNotFoundException 
	{
		if (ed.existsById(employeeId)) {
			ed.deleteById(employeeId);
			return "Deleted Successfully for id:" + employeeId;
		}
		throw new EmployeeIdNotFoundException("Employee Not Found For Id :" + employeeId);
	}

}
