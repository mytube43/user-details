package com.channel.service.user.controller;

import com.channel.service.user.framework.vo.MTResponseVO;
import com.channel.service.user.model.Response;
import com.channel.service.user.model.StringResponseModel;
import com.channel.service.user.model.UserModel;
import com.channel.service.user.model.UserRegistrationVO;
import com.channel.service.user.service.IRegisterUserService;
import com.channel.service.user.service.UserService;
import com.channel.service.user.util.ResponseUtil;
import com.channel.service.user.validator.UserValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/service/v1")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator validator;
	
	@Autowired
	IRegisterUserService registrationService;
	
	@PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> register(@RequestBody UserModel user) {
		if(!validator.validate(user)) {
			return ResponseUtil.getResponseEntity(HttpStatus.BAD_REQUEST, new StringResponseModel("Invalid request"));
		}
		userService.saveUser(user);
		return ResponseUtil.getResponseEntity(HttpStatus.OK, new StringResponseModel("user registration completed successfully."));
	}
	
	@PostMapping(value = "/userRegistration")
	public ResponseEntity<MTResponseVO> registerUser(@RequestBody String payload) {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
	
		UserRegistrationVO user=null;
		try {
			user = objMapper.readValue(payload, UserRegistrationVO.class);
			MTResponseVO responseVO =registrationService.registerUser(user);
		
				return new ResponseEntity<MTResponseVO>(responseVO,HttpStatus.OK);
		} catch (JsonProcessingException e) {
			
			log.error("Exception while transforming request"+e);
		}
		return new ResponseEntity<MTResponseVO>(new MTResponseVO(),HttpStatus.BAD_REQUEST);
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
