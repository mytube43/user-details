package com.channel.service.user.service;


import com.channel.service.user.framework.vo.MTResponseVO;
import com.channel.service.user.model.UserRegistrationVO;

public interface IRegisterUserService {

	public MTResponseVO registerUser(UserRegistrationVO userRegisterData);
}
