package com.maxvone.userservice.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.maxvone.userservice.domain.dto.AuthDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;

@Component
public class AuthMapper implements Mapper<UserEntity, AuthDto> {

    private ModelMapper modelMapper;

    public AuthMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, AuthDto.class);
    }

    @Override
    public UserEntity mapFrom(AuthDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }
}
