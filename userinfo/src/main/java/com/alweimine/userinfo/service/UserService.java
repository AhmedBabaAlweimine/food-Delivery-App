package com.alweimine.userinfo.service;

import com.alweimine.userinfo.dto.UserDto;
import com.alweimine.userinfo.entity.User;
import com.alweimine.userinfo.mapper.UserMapper;
import com.alweimine.userinfo.repo.UseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UseRepo useRepo;

    public UserDto saveUser(UserDto userDto) {
        return UserMapper.INSTANCE.mapUserToUserDto(useRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto)));
    }

    public UserDto getUserById(Integer userId) {
        User user = useRepo.findById(userId).orElseThrow(() -> new RuntimeException("No user Found"));
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }
}
