package com.cvm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String empName;
	private String password;
	private Date birthdate;
	private String mobileNo;
	
	@ManyToMany
	List<Slot> slots;
	
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	@JsonIgnore
	List<VitalsAtVaccination> vitals;
	
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Certification> certificates;
}
