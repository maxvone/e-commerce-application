package com.maxvone.userservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxvone.userservice.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{

}
