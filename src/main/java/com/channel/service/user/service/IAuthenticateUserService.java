package com.channel.service.user.service;

import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.MTRequestVO;

public interface IAuthenticateUserService {

	public void authenticateUserByIdPwd( MTRequestVO requestVO,WorkflowContextMap contextMap);
}
