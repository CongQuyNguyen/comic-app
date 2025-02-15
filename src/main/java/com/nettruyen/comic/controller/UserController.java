package com.nettruyen.comic.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nettruyen.comic.dto.request.UserCreationRequest;
import com.nettruyen.comic.dto.request.UserUpdate;
import com.nettruyen.comic.dto.response.ApiResponse;
import com.nettruyen.comic.dto.response.UserResponse;
import com.nettruyen.comic.service.IUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserController {

    IUserService userService;

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .result(userService.createUser(userCreationRequest))
                .build();
    }
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers(){
        return ApiResponse.<List<UserResponse>>builder()
                .code(200)
                .result(userService.findAllUsers())
                .build();

    }
    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUser(@PathVariable String id){
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .result(userService.findUserById(id))
                .build();

    }
    @GetMapping("/me")
    ApiResponse<UserResponse> getUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .result(userService.findUserByUsername(username))
                .build();
    }


    @PutMapping("/{id}")
    ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdate request){
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .result(userService.updateUser(id,request))
                .build();

    }
    @DeleteMapping("/{id}")
    ApiResponse<?> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Delete user successfully")
                .build();
    }
}
