package com.channel.service.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.channel.service.user.entity.User;
import com.channel.service.user.model.UserRegistrationVO;

@Repository
public class UserRegistrationDAOImpl implements IUserRegistrationDAO{
	
	Logger log = LoggerFactory.getLogger(UserRegistrationDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_USER_REG_DATA = "insert into users(userid,name,age,email,registereddate,first_name,last_name,dob,gender,state) values(?,?,?,?,current_timestamp,? ,?,?,?,?)";
	@Override
	public boolean addUserRegData(UserRegistrationVO userdata) {
		try {
		int insertedrow=jdbcTemplate.update(INSERT_USER_REG_DATA, new Object[] {userdata.getUserId(),userdata.getFirstName()+" "+userdata.getLastName()
		,27,userdata.getEmail(),userdata.getFirstName(),userdata.getLastName(),userdata.getDob(),userdata.getGender(),userdata.getState()});
		
		log.debug("inserted row for userregistration="+insertedrow);
		if(insertedrow>0) {
			return true;
		}
		return false;
		}catch (Exception e) {
			log.error("Exception while inserting user registration data in db",e);
		}
		return false;
	}

}
