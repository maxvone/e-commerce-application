package com.maxvone.userservice.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.dto.RegisterUserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;
import com.maxvone.userservice.repositories.UserRepository;
import com.maxvone.userservice.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private Mapper<UserEntity, UserDto> authMapper;
    private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, Mapper<UserEntity, UserDto> authMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto register(RegisterUserDto registerUserDto) {
        UserEntity user = createUserFromRegistrationData(registerUserDto);
        UserEntity savedUserEntity = userRepository.save(user);

        return authMapper.mapTo(savedUserEntity);
    }

    private UserEntity createUserFromRegistrationData(RegisterUserDto registerUserDto) {
        UserEntity userEntity = UserEntity.builder()
                .username(registerUserDto.getUsername())
                .email(registerUserDto.getEmail())
                .passwordHash(passwordEncoder.encode(registerUserDto.getRawPassword()))
                .build();

        return userEntity;
    }

}
