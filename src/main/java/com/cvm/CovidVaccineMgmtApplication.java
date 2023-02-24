package com.cvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info=@Info(title="Covid Vaccination Management"))
@SpringBootApplication
public class CovidVaccineMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidVaccineMgmtApplication.class, args);
	}

}