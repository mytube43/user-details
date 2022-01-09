package com.channel.service.user.model;

public class StringResponseModel implements Model {

	private String message;

	public StringResponseModel() {

	}

	public StringResponseModel(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
