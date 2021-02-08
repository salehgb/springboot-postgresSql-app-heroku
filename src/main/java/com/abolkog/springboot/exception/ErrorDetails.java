package com.abolkog.springboot.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timsTemp;
	private String message;
	private String details;

	public ErrorDetails(Date date, String message, String details) {
		super();
		this.timsTemp = date;
		this.message = message;
		this.details = details;
	}

	public Date getTimsTemp() {
		return timsTemp;
	}

	public void setTimsTemp(Date timsTemp) {
		this.timsTemp = timsTemp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
