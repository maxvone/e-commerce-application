package com.maxvone.userservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxvone.userservice.domain.dto.RegisterUserDto;
import com.maxvone.userservice.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    private AuthService authService;

    public RegisterController(AuthService userService) {
        this.authService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody RegisterUserDto userRegisterDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(authService.register(userRegisterDto)); 
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error registering user\"}");
        }
    }
}
