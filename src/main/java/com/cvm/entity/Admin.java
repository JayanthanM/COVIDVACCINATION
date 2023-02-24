package com.cvm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Admin{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	@NotEmpty
	private String password;
	@Email(regexp ="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="mail is in correct")
	private String emailId;
	@NotEmpty(message = "please provide Location")
	private String location;
	
	@OneToMany(mappedBy ="admin", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Slot> slots;
	
}
