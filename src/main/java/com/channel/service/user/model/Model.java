package com.channel.service.user.model;

import org.springframework.http.HttpStatus;

public interface Model {
	
	static String getStatusCode(HttpStatus status) {
		return String.valueOf(status.value());
	}
	
	static String getMessage(HttpStatus status) {
		return status.getReasonPhrase();
	}

}
