package com.cvm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvm.entity.VitalsAtVaccination;

@Repository("vt")
public interface VitalsAtVaccinationDao extends JpaRepository<VitalsAtVaccination, Long>
{
	
}
