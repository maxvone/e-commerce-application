package com.maxvone.userservice.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.maxvone.userservice.domain.dto.ProductDtoTemp;
import com.maxvone.userservice.domain.dto.UserDto;
import com.maxvone.userservice.domain.entities.UserEntity;
import com.maxvone.userservice.mappers.Mapper;
import com.maxvone.userservice.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Value("${product.service.base.url}")
    private String productServiceUrl;

    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;
    private RestTemplate restTemplate;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper, RestTemplate restTemplate) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") UUID id) {
        Optional<UserEntity> foundUser = userService.getUserById(id);

        return foundUser.map(user -> {
            UserDto userDto = userMapper.mapTo(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {

        String url = productServiceUrl + "/" + id;
    
        try {

            ResponseEntity<ProductDtoTemp> response = restTemplate.getForEntity(url, ProductDtoTemp.class);
            return response;

        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Unable to fetch product details: " + e.getMessage(), e);
        }
    }
}