package com.cvm.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String path;
	public ErrorInfo() {
	}
	public ErrorInfo(LocalDateTime timestamp, String status, String error, String path) {
	super();
	this.timestamp = timestamp;
	this.status = status;
	this.error = error;
	this.path = path;
	}
}
