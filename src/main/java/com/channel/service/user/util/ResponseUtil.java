package com.channel.service.user.util;

import com.channel.service.user.model.Model;
import com.channel.service.user.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseUtil {
	
	public static Response getResponse(HttpStatus httpStatus, Model model) {
		return new Response(Model.getStatusCode(httpStatus),Model.getMessage(httpStatus),model);
	}
	
	public static ResponseEntity<Response> getResponseEntity(HttpStatus httpStatus, Model model) {
		return new ResponseEntity(new Response(Model.getStatusCode(httpStatus),Model.getMessage(httpStatus),model), httpStatus);
	}
}
