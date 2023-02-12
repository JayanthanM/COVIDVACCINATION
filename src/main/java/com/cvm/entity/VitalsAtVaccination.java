package com.cvm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vitals_Details")

public class VitalsAtVaccination {

	@Id
	@GeneratedValue
	private long vitalId;
	@Min(value = 95, message = "Please provide temperature betweem 95-99")
	@Max(value = 99, message = "Please provide temperature betweem 95-99")
	private float vitalTemperature;
	@Min(value = 42, message = "Please provide a saturation value between 42-81")
	@Max(value = 81, message = "Please provide a saturation value between 42-81")
	private float vitalSaturation;
	@Min(value = 90, message = "Please provide Blood pressure between 90-120")
	@Max(value = 120, message = "Please provide Blood pressure between 90-120")
	private float vitalBloodPressure;
	@NotEmpty(message = "Please provide time")
	private String vitalTime;

	@ManyToOne
	//@JsonIgnore
	Slot slots;

	@ManyToOne
	//@JsonIgnore
	MedicalStaff medicalStaff;
	
	@ManyToOne
	Employees employees;

}
