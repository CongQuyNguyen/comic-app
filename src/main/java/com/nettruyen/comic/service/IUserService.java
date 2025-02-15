package com.nettruyen.comic.service;

import com.nettruyen.comic.dto.request.UserCreationRequest;
import com.nettruyen.comic.dto.request.UserUpdate;
import com.nettruyen.comic.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse createUser(UserCreationRequest request);

    UserResponse updateUser(String id,UserUpdate request);

    void deleteUser(String id);

    UserResponse findUserByUsername(String username);
    UserResponse findUserById(String id);
    List<UserResponse> findAllUsers();
}
