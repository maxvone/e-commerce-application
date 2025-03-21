package com.maxvone.userservice.services;

import com.maxvone.userservice.domain.entities.UserEntity;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

}
