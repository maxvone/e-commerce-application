package com.maxvone.userservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;
import com.maxvone.userservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private Mapper<UserEntity, UserDto> userMapper;
    private UserService userService;


    public UserController(Mapper<UserEntity, UserDto> userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapFrom(userDto);
        UserEntity savedUserEntity = userService.saveUser(userEntity);
        
        return new ResponseEntity<>(userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);

    }

}
