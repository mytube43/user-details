package com.channel.service.user.model;

public class Response {
	
	private String statusCode;
	
	private String message;
	
	private Model responseBody;
	
	public Response() {}
	
	public Response(String statusCode, String message, Model model) {
		this.statusCode = statusCode;
		this.message = message;
		this.responseBody = model;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Model getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Model responseBody) {
		this.responseBody = responseBody;
	}
	
	

}
