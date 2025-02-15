package com.nettruyen.comic.mapper;

import com.nettruyen.comic.dto.request.UserCreationRequest;
import com.nettruyen.comic.dto.request.UserUpdate;
import com.nettruyen.comic.dto.response.UserResponse;
import com.nettruyen.comic.entity.UserEntity;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(UserCreationRequest userCreationRequest);

    UserResponse toUserResponse(UserEntity userEntity);
    void updateUser(@MappingTarget UserEntity user, UserUpdate request);

}
