package com.channel.service.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.channel.service.user.entity.User;
import com.channel.service.user.framework.vo.MTPage;
import com.channel.service.user.framework.vo.MTResponseBody;
import com.channel.service.user.framework.vo.MTResponseStatus;
import com.channel.service.user.framework.vo.MTResponseVO;
import com.channel.service.user.model.UserRegistrationVO;
import com.channel.service.user.util.MTResponseUtil;



@Component
public class RegisterUserServiceImpl implements IRegisterUserService{

	Logger log = LoggerFactory.getLogger(RegisterUserServiceImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	IUserRegistrationDAO userRegistrationDAO;
	
	@Override
	public MTResponseVO registerUser(UserRegistrationVO userRegisterData) {
		MTResponseVO responseVO = MTResponseUtil.getResponseVO("userRegistration");
		MTResponseStatus responseStatus = new MTResponseStatus();
		try {
			log.debug("**************** JDBCtemplate*************** "+jdbcTemplate);
			userRegisterData.setDob(userRegisterData.getDob().split("T")[0]);
			boolean isUserDataSaved =userRegistrationDAO.addUserRegData(userRegisterData);
			if(isUserDataSaved) {
				responseStatus.setResponseCode("00000");
				responseStatus.setResponseStatus("Success");
			}else {
				responseStatus.setResponseCode("11111");
				responseStatus.setResponseStatus("Error");
			}
			responseVO.setResponseInfo(responseStatus);
			log.debug("UserRegistration data saved to DB!:: {}",isUserDataSaved);
		}catch (Exception e) {
			log.error("Exception while saving user registration data to DB",e);
		}
		
		return responseVO;
		
	}

}
