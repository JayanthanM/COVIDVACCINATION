package com.cvm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvm.entity.Employees;
@Repository("ed")
public interface EmployeesDao extends JpaRepository<Employees,Long> {

	Optional<Employees> findByMobileNo(String mobileNo);
	

}
