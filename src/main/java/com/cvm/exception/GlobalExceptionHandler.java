package com.cvm.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cvm.response.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String , String>> HandleException(MethodArgumentNotValidException te){
	Map<String , String> errorMap = new LinkedHashMap<>();
	List<FieldError> list =te.getFieldErrors();
	for(FieldError f : list){
	String fieldName = f.getField();
	String errorMsg = f.getDefaultMessage();
	errorMap.put(fieldName, errorMsg);
	}
	ResponseEntity<Map<String , String>> rEntity = new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
	return rEntity;
	}
	
@ExceptionHandler(AdminsIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(AdminsIdNotFoundException ex,HttpServletRequest request)
	{
		String msg=ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity=new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoAdminsFoundException ex,HttpServletRequest request)
	{
		String msg=ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity=new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
@ExceptionHandler(CertificatesIdNotFoundException.class)
public ResponseEntity<ErrorInfo> handlingException(CertificatesIdNotFoundException ex,HttpServletRequest request)
{
	String msg=ex.getMessage();
	ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity=new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(NoVitalsFoundException.class)
public ResponseEntity<ErrorInfo> HandlingException(NoVitalsFoundException ex, HttpServletRequest request) {
	String msg = ex.getMessage();
	ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(VitalIdNotFoundException.class)
public ResponseEntity<ErrorInfo> HandlingException(VitalIdNotFoundException ex, HttpServletRequest request) {
	String msg = ex.getMessage();
	ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(SlotIdNotFoundException.class)
public ResponseEntity<ErrorInfo> HandlingException(SlotIdNotFoundException ex, HttpServletRequest request) {
	String msg = ex.getMessage();
	ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(NoSlotFoundException.class)
public ResponseEntity<ErrorInfo> HandlingException(NoSlotFoundException ex, HttpServletRequest request) {
	String msg = ex.getMessage();
	ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(IdNotMatchException.class)
public ResponseEntity<ErrorInfo> HandlingException(IdNotMatchException ex, HttpServletRequest request) {
	String msg = ex.getMessage();
	ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
	ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
	return rEntity;
}

@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<String> handlingException(EmployeeNotFoundException ex) {
String msg = ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
return rEntity;
}

@ExceptionHandler(EmployeeIdNotFoundException.class)
public ResponseEntity<ErrorInfo> handlingException(EmployeeIdNotFoundException ex,HttpServletRequest request)
{
String msg=ex.getMessage();
ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,request.getRequestURI());
ResponseEntity<ErrorInfo> rEntity=new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
return rEntity;
}

@ExceptionHandler(EmployeeMobileNoNotExistingException.class)
public ResponseEntity<ErrorInfo> handlingException(EmployeeMobileNoNotExistingException ex, HttpServletRequest request) {
String msg = ex.getMessage();
ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg,request.getRequestURI());
ErrorInfo err = new ErrorInfo();
ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(err, HttpStatus.NOT_FOUND);
return rEntity;
}

@ExceptionHandler(EmployeeAuthenticationFailureException.class)
public ResponseEntity<String> handlingException(EmployeeAuthenticationFailureException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
@ExceptionHandler(MedicalStaffIdNotFoundException.class)
public ResponseEntity<String> handlingException(MedicalStaffIdNotFoundException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
@ExceptionHandler(NoCertificatesFoundException.class)
public ResponseEntity<String> handlingException(NoCertificatesFoundException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
@ExceptionHandler(NoEmployeesFoundException.class)
public ResponseEntity<String> handlingException(NoEmployeesFoundException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
@ExceptionHandler(NoMedicalStaffFoundException.class)
public ResponseEntity<String> handlingException(NoMedicalStaffFoundException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
@ExceptionHandler(EmailIdNotFoundException.class)
public ResponseEntity<String> handlingException(EmailIdNotFoundException ex) {
String msg= ex.getMessage();
ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
return rEntity;
}
}