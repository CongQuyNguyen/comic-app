package com.nettruyen.comic.repository;

import com.nettruyen.comic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
