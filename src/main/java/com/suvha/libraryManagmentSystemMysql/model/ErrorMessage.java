package com.suvha.libraryManagmentSystemMysql.model;

import java.util.Date;
import java.util.Map;

public class ErrorMessage {
	private Date timestamp;
	private String errorMessage;
	private Map<String, String> detail;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(Date timestamp, String errorMessage, Map<String, String>  detail) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, String>  getDetail() {
		return detail;
	}

	public void setDetail(Map<String, String>  requestedURL) {
		this.detail = requestedURL;
	}
	

}
