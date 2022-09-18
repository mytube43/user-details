package com.channel.service.user.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.channel.service.user.framework.MTServiceController;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseVO;

/**
 * 
 * @author Amit
 *
 */
@RestController
@RequestMapping("/user/service/v1")
public class AuthenticateUserController extends MTServiceController{

	@PostMapping("/authenticateUserByUserId")
	public @ResponseBody MTResponseVO  autenticateUserByUserId( @RequestBody MTRequestVO requestVO){
		//log.info("Starting VideoFeedController >>>>>>>>>>>");
		MTResponseVO responseVO= execute(requestVO, "authenticateUserById", "authenticateUserByIdPwd");
		
		return responseVO;
		
	}
}
