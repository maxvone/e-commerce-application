package com.maxvone.userservice.services;

import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.dto.RegisterUserDto;

public interface AuthService {

    UserDto register(RegisterUserDto userEntity);

}
