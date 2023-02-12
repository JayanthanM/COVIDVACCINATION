package com.cvm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvm.entity.Certification;

@Repository("cd")
public interface CertificationDao extends JpaRepository<Certification, Long>{

}
