package com.channel.service.user.service;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseVO;
import com.channel.service.user.util.UserServicePageType;


@Component("authenticateUserById")
public class AuthenticateUserServiceImpl implements IAuthenticateUserService{

	@Override
	public void authenticateUserByIdPwd( MTRequestVO requestVO,WorkflowContextMap contextMap) {
		MTResponseVO responseVO = contextMap.getMTResponse("responseVO");
		String userId ="";
		String pwd = "";
		if(null!=requestVO.getRequestMap().get("userId")) {
			userId= new String(Base64.getDecoder().decode(requestVO.getRequestMap().get("userId").toString()));
			pwd =new String(Base64.getDecoder().decode(requestVO.getRequestMap().get("password").toString()));
		}
		responseVO.getResponseBody().getPage().setPageType(UserServicePageType.AUTH_USER_BY_ID_PAGE_TYPE);
		responseVO.getResponseBody().getPage().getPageMap().put("isUserIdAuthenticated","true");
			
		
	}
}
