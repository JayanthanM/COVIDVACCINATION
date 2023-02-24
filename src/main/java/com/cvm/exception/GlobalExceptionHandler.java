package com.cvm.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> HandleException(MethodArgumentNotValidException te) {
		Map<String, String> errorMap = new LinkedHashMap<>();
		List<FieldError> list = te.getFieldErrors();
		for (FieldError f : list) {
			String fieldName = f.getField();
			String errorMsg = f.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);
		}
		ResponseEntity<Map<String, String>> rEntity = new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		return rEntity;
	}

@ExceptionHandler(AdminsIdNotFoundException.class)
	public ResponseEntity<String> handlingException(AdminsIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(CertificatesIdNotFoundException.class)
	public ResponseEntity<String> handlingException(CertificatesIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<String> handlingException(NoAdminsFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
	
@ExceptionHandler(NoVitalsFoundException.class)
	public ResponseEntity<String> handlingException(NoVitalsFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(VitalIdNotFoundException.class)
	public ResponseEntity<String> handlingException(VitalIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
	
@ExceptionHandler(SlotIdNotFoundException.class)
	public ResponseEntity<String> handlingException(SlotIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(NoSlotFoundException.class)
	public ResponseEntity<String> handlingException(NoSlotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(IdNotMatchException.class)
	public ResponseEntity<String> handlingException(IdNotMatchException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<String> handlingException(EmployeeIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(EmployeeMobileNoNotExistingException.class)
	public ResponseEntity<String> handlingException(EmployeeMobileNoNotExistingException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(EmployeeAuthenticationFailureException.class)
	public ResponseEntity<String> handlingException(EmployeeAuthenticationFailureException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(MedicalStaffIdNotFoundException.class)
	public ResponseEntity<String> handlingException(MedicalStaffIdNotFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(NoCertificatesFoundException.class)
	public ResponseEntity<String> handlingException(NoCertificatesFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
@ExceptionHandler(NoEmployeesFoundException.class)
	public ResponseEntity<String> handlingException(NoEmployeesFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}
	
@ExceptionHandler(NoMedicalStaffFoundException.class)
	public ResponseEntity<String> handlingException(NoMedicalStaffFoundException ex)
	{
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
		}

@ExceptionHandler(EmailIdNotFoundException.class)
public ResponseEntity<String> handlingException(EmailIdNotFoundException ex)
{
	String msg= ex.getMessage();
	ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	return rEntity;
	}

}