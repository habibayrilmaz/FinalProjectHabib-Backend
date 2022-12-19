package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.UserRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserResponseDto;
import com.example.finalprojecthabibbackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(implementationName = "UserMapperImpl", componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequestDto userRequestDto);

    @Mapping(source = "userContactInfo.id", target = "userContactInfoId")
    UserResponseDto toUserDto(User user);

    User toUserFromCreateUserRequest(UserRequestDto userRequestDto);

    List<UserResponseDto> toUserDTOs(List<User> users);
}
