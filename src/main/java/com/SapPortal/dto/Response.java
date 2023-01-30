package com.SapPortal.dto;

import com.SapPortal.models.Status;

public class Response {
	Status status;
	Object message;

	public Response() {

	}

	public Response(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Response(Status status, Object message, Boolean t) {
		super();
		this.status = status;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
}
