package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.UserRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.UserMapper;
import com.example.finalprojecthabibbackend.model.entity.User;
import com.example.finalprojecthabibbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapperUser;

    @Transactional
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = mapperUser.toUserFromCreateUserRequest(userRequestDto);
        return mapperUser.toUserDto(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(mapperUser::toUserDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponseDto getUser(Long userId) {
        return userRepository.findById(userId).map(mapperUser::toUserDto).orElseThrow(() -> new NotFoundException("could not find this id : " + userId));
    }

    @Transactional(readOnly = true)
    @Override
    public User getUsers(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("could not find this id : " + userId));
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        return userRepository.findById(userId)
                .map(user -> updateUserDto(userRequestDto, user))
                .map(userRepository::save)
                .map(mapperUser::toUserDto)
                .orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    private static User updateUserDto(UserRequestDto userRequestDto, User user) {
        user.setUserName(userRequestDto.getUserName());
        user.setUserMailAddress(userRequestDto.getUserMailAddress());
        user.setUserDepartment(userRequestDto.getUserDepartment());
        user.setUserRole(userRequestDto.getUserRole());
        user.setUserSalary(userRequestDto.getUserSalary());
        user.setUserSeniority(userRequestDto.getUserSeniority());
        user.setUserSurname(userRequestDto.getUserSurname());
        user.setUserBirthDate(userRequestDto.getUserBirthDate());
        user.setUserSeniorityLevel(userRequestDto.getUserSeniorityLevel());
        user.setUserStartDate(userRequestDto.getUserStartDate());
        user.setUserIdentificationNumber(userRequestDto.getUserIdentificationNumber());
        return user;
    }

}
