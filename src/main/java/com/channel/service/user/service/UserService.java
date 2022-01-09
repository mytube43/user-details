package com.channel.service.user.service;

import com.channel.service.user.entity.User;
import com.channel.service.user.mapper.UserMapper;
import com.channel.service.user.model.UserModel;
import com.channel.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser (UserModel user) {
        return userRepository.save(UserMapper.INSTANCE.mapToUserEntity(user));
    }

    public UserModel getUser(String userId) {
        User user = userRepository.findByUserId(userId);
        return UserMapper.INSTANCE.mapToUserModel(user);
    }

}
