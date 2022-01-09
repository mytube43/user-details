package com.channel.service.user.validator;

import com.channel.service.user.model.UserModel;
import org.springframework.stereotype.Component;


@Component
public class UserValidator {

	public boolean validate(UserModel userModel) {
		return userModel != null ? true : false;
	}
}
