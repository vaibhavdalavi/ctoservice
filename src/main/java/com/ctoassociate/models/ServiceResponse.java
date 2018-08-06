package com.ctoassociate.models;

import java.io.Serializable;
import java.text.MessageFormat;

public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private StatusEnum status;
	private String message;

	public ServiceResponse() {
		this.status = StatusEnum.SUCCESS;
		this.message = "Request processed Successfully.";
	}
	
	public ServiceResponse(Integer id) {
		this.status = StatusEnum.SUCCESS;
		this.message = "Created Successfully. Following is the ID generated for your reference : " + id;
	}
	
	public ServiceResponse(Long id) {
		this.status = StatusEnum.SUCCESS;
		this.message = "Created Successfully. Following is the ID generated for your reference : " + id;
	}

	public ServiceResponse(String message) {
		status = StatusEnum.SUCCESS;
		this.message = message;
	}
	
	public ServiceResponse setId(Object id) {
		this.message += " Following is the ID generated for your reference : " + id;
		return this;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceResponse failed() {
		this.status = StatusEnum.FAILED;
		return this;
	}

	public ServiceResponse success(String message) {
		this.status = StatusEnum.SUCCESS;
		this.message = message;
		return this;
	}

	public ServiceResponse failed(String message) {
		this.status = StatusEnum.FAILED;
		this.message = message;
		return this;
	}

	public ServiceResponse failed(String message, Object... args) {
		MessageFormat messageFormat = new MessageFormat(message);
		this.status = StatusEnum.FAILED;
		this.message = messageFormat.format(args);
		return this;
	}
	public ServiceResponse appendMessage(String message) {
		this.message += " " + message;
		return this;
	}
	
	public ServiceResponse setNumberOfRowsAffected(Integer noOfRowsAffected) {
		
		if(noOfRowsAffected < 0) {
			noOfRowsAffected = 0;
		}
		this.message += " Total rows affected is " + noOfRowsAffected + ".";
		return this;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", message=" + message + "]";
	}
	
	public void update(ServiceResponse response) {
		this.setStatus(response.getStatus());
		this.setMessage(response.getMessage());
	}

}
