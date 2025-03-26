package com.maxvone.userservice.services.impl;

import org.springframework.stereotype.Service;

import com.maxvone.userservice.domain.dto.AuthDto;
import com.maxvone.userservice.domain.dto.RegisterUserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;
import com.maxvone.userservice.repositories.UserRepository;
import com.maxvone.userservice.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private Mapper<UserEntity, AuthDto> authMapper;

    public AuthServiceImpl(UserRepository userRepository, Mapper<UserEntity, AuthDto> authMapper) {
        this.userRepository = userRepository;
        this.authMapper = authMapper;
    }

    @Override
    public AuthDto register(RegisterUserDto registerUserDto) {
        UserEntity user = createUserFromRegistrationData(registerUserDto);
        UserEntity savedUserEntity = userRepository.save(user);

        return authMapper.mapTo(savedUserEntity);
    }

    private UserEntity createUserFromRegistrationData(RegisterUserDto registerUserDto) {
        UserEntity userEntity = UserEntity.builder()
                .username(registerUserDto.getUsername())
                .email(registerUserDto.getEmail())
                .passwordHash(registerUserDto.getRawPassword()) //TODO: Hash password
                .build();

        return userEntity;
    }

}
