package com.dinosatrovic.newsportal.users.db;

import com.dinosatrovic.newsportal.users.db.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{

    Optional<UserEntity> findById(UUID userId);

    Optional<UserEntity> findByUsername(String username);
}
