package com.maxvone.userservice.services;

import java.util.Optional;
import java.util.UUID;

import com.maxvone.userservice.domain.entities.UserEntity;

public interface UserService {
    Optional<UserEntity> getUserById(UUID id);
}
