package com.alweimine.userinfo.mapper;

import com.alweimine.userinfo.dto.UserDto;
import com.alweimine.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDtoToUser(UserDto userDto);

    UserDto mapUserToUserDto(User user);
}
