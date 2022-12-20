package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.UserRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserResponseDto;
import com.example.finalprojecthabibbackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(implementationName = "UserMapperImpl", componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userContactInfo.id", target = "userContactInfoId")
    UserResponseDto toUserDto(User user);

    User toUserFromCreateUserRequest(UserRequestDto userRequestDto);
}
