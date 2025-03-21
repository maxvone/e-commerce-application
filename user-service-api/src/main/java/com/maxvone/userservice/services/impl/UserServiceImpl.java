package com.maxvone.userservice.services.impl;

import org.springframework.stereotype.Service;

import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.repositories.UserRepository;
import com.maxvone.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

}
