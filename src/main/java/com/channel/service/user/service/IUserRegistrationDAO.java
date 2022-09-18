package com.channel.service.user.service;

import com.channel.service.user.entity.User;
import com.channel.service.user.model.UserRegistrationVO;

public interface IUserRegistrationDAO {

	public boolean addUserRegData(UserRegistrationVO userdata);
}
