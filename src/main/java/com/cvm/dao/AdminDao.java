package com.cvm.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvm.entity.Admin;
@Repository("ad")
public interface AdminDao extends JpaRepository<Admin , Long> {

	Optional<Admin> findByEmailId(String emailId);
	
	

}
