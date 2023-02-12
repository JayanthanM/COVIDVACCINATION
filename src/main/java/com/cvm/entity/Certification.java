package com.cvm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Certification {
	@Id
	private long certificateId;
	
	@ManyToOne
	private Employees employees;

}
