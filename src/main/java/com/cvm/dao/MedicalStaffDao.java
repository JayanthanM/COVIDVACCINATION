package com.cvm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cvm.entity.MedicalStaff;

@Repository("msd")
public interface  MedicalStaffDao extends JpaRepository<MedicalStaff,Long> {

	Optional<MedicalStaff> findByEmailId(String emailId);

//	@Query("select e from MedicalStaff e where e.emailId =:emailId and e.password =:pwd")
//	 Optional<MedicalStaff> login(@Param("emailId") String emailId,@Param("pwd") String password);
//
//	
//	Optional<MedicalStaff> findByEmailId(String emailId);
//  Optional<MedicalStaff> findById(long staffId);
}