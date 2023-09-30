package com.group1.monolithsem4.mapstruct;


import com.group1.monolithsem4.dto.user.UserReferResponse;
import com.group1.monolithsem4.dto.user.UserRequest;
import com.group1.monolithsem4.dto.user.UserResponse;
import com.group1.monolithsem4.dto.user.UserUpdateRequest;
import com.group1.monolithsem4.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = EntityMapper.class)

public interface UserMapper {

    UserResponse toResponse(UserEntity userEntity);
    UserResponse toResponse(UserReferResponse referResponse);
    UserReferResponse toReferResponse(UserEntity userEntity);


    UserEntity toEntity(UserRequest userRequest);

    void updateEntity(UserUpdateRequest userUpdateRequest, @MappingTarget UserEntity userEntity);

}
