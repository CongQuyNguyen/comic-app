package com.nettruyen.comic.repository;

import com.nettruyen.comic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);
}
