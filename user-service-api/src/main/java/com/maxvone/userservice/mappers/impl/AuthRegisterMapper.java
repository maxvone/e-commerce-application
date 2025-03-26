package com.maxvone.userservice.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.maxvone.userservice.domain.dto.RegisterUserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;

@Component
public class AuthRegisterMapper implements Mapper<UserEntity, RegisterUserDto> {

    private ModelMapper modelMapper;

    public AuthRegisterMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RegisterUserDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, RegisterUserDto.class);
    }

    @Override
    public UserEntity mapFrom(RegisterUserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
