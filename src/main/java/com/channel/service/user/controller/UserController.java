package com.channel.service.user.controller;

import com.channel.service.user.model.Response;
import com.channel.service.user.model.StringResponseModel;
import com.channel.service.user.model.UserModel;
import com.channel.service.user.service.UserService;
import com.channel.service.user.util.ResponseUtil;
import com.channel.service.user.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel/service/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator validator;
	
	@PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> register(@RequestBody UserModel user) {
		if(!validator.validate(user)) {
			return ResponseUtil.getResponseEntity(HttpStatus.BAD_REQUEST, new StringResponseModel("Invalid request"));
		}
		userService.saveUser(user);
		return ResponseUtil.getResponseEntity(HttpStatus.OK, new StringResponseModel("user registration completed successfully."));
	}

	@GetMapping("/users")
	public ResponseEntity<Response> retrieveUser(@RequestParam("userId") String userId) {
		if(userId != null) {
			UserModel user = userService.getUser(userId);
			return ResponseUtil.getResponseEntity(HttpStatus.OK, user);
		}
		return ResponseUtil.getResponseEntity(HttpStatus.BAD_REQUEST, new StringResponseModel("Invalid request, userId is mandatory parameter"));
	}

}
