package com.channel.service.user.mapper;

import com.channel.service.user.entity.User;
import com.channel.service.user.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mappings({
            @Mapping(source = "id.state", target = "state")
    })
    UserModel mapToUserModel(User user);

    @Mappings({
            @Mapping(source = "email", target = "id.userid"),
            @Mapping(source = "state", target = "id.state"),
            @Mapping(expression = "java(java.time.LocalDateTime.now())", target = "registereddate")
    })
    User mapToUserEntity(UserModel user);

}
