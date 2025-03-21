package com.maxvone.userservice.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;

@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {

    private ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
