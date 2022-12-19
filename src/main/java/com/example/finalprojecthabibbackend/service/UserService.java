package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.UserRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserResponseDto;
import com.example.finalprojecthabibbackend.model.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUser(Long userId);
    User getUsers(Long userId);
    void deleteById(Long userId);
    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

}
