package com.cvm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "Slots")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slotId;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Please provide a Date")
	private LocalDate slotDate;
		
	@NotEmpty(message = "Please provide Location")
	private String slotLocation;
	
	@Min(value = 1,message ="enter either 1 or 2")
	@Max(value = 2,message ="enter either 1 or 2")
	private int doseNo;
	
	@Min(value = 0 , message ="Current slots must be positive")
	private int currentSlots;
	
	@Min(value = 0 , message="Available slots must be positive")
	private int balanceSlots;
	
	@ManyToOne
	Admin admin;
	
	@ManyToMany(mappedBy="slots")
	@JsonIgnore
	List<Employees> employees;

	@OneToMany(cascade = CascadeType.ALL , mappedBy = "slots")
	@JsonIgnore
	List<VitalsAtVaccination> vitals;
	
}
