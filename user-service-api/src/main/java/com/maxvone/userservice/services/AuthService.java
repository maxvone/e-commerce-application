package com.maxvone.userservice.services;

import com.maxvone.userservice.domain.dto.AuthDto;
import com.maxvone.userservice.domain.dto.RegisterUserDto;

public interface AuthService {

    AuthDto register(RegisterUserDto userEntity);

}
