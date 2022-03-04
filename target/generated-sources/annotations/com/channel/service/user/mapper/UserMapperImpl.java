package com.channel.service.user.mapper;

import com.channel.service.user.entity.User;
import com.channel.service.user.entity.UserPK;
import com.channel.service.user.model.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T00:33:06+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel mapToUserModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setState( userIdState( user ) );
        userModel.setName( user.getName() );
        userModel.setAge( user.getAge() );
        userModel.setEmail( user.getEmail() );
        userModel.setAddress( user.getAddress() );
        userModel.setCountry( user.getCountry() );

        return userModel;
    }

    @Override
    public User mapToUserEntity(UserModel user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( userModelToUserPK( user ) );
        user1.setAddress( user.getAddress() );
        user1.setAge( user.getAge() );
        user1.setCountry( user.getCountry() );
        user1.setEmail( user.getEmail() );
        user1.setName( user.getName() );

        user1.setRegistereddate( java.time.LocalDateTime.now() );

        return user1;
    }

    private String userIdState(User user) {
        if ( user == null ) {
            return null;
        }
        UserPK id = user.getId();
        if ( id == null ) {
            return null;
        }
        String state = id.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    protected UserPK userModelToUserPK(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserPK userPK = new UserPK();

        userPK.setUserid( userModel.getEmail() );
        userPK.setState( userModel.getState() );

        return userPK;
    }
}
