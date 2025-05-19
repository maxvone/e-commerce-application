package com.maxvone.userservice.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;
import com.maxvone.userservice.services.UserService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;

    @Autowired
    private RestTemplate restTemplate;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") UUID id) {
        Optional<UserEntity> foundUser = userService.getUserById(id);

        return foundUser.map(user -> {
            UserDto userDto = userMapper.mapTo(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/test")
    public String getTest(){
        String url = "http://product-service/api/products/1";
        return restTemplate.getForEntity(url, String.class).toString();
    }
}
