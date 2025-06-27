package com.alweimine.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String userName;
    private String userPassword;
    private String adress;
    private String city;
}
