package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserContactInfoResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.UserContactInfoMapper;
import com.example.finalprojecthabibbackend.model.entity.User;
import com.example.finalprojecthabibbackend.model.entity.UserContactInfo;
import com.example.finalprojecthabibbackend.repository.UserContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserContactInfoServiceImpl implements UserContactInfoService {
    private final UserContactInfoMapper userContactInfoMapper;
    private final UserContactInfoRepository userContactInfoRepository;
    private final UserService userService;

    @Transactional
    @Override
    public UserContactInfoResponseDto createUserContactInfo(UserContactInfoRequestDto userContactInfoRequestDto) {
        User user = userService.getUsers(userContactInfoRequestDto.getUserId());
        if (user.getId() == null) {
            throw new NotFoundException("UserContactInfoId Not Found!");
        }
        UserContactInfo userContactInfo = userContactInfoMapper.toUserContactInfoFromCreateUserContactInfoRequest(userContactInfoRequestDto);
        userContactInfo.setUser(user);
        return userContactInfoMapper.toUserContactInfoDto(userContactInfoRepository.save(userContactInfo));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserContactInfoResponseDto> getAllUserContactInfo() {
        return userContactInfoRepository.findAll().stream().map(userContactInfoMapper::toUserContactInfoDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public UserContactInfoResponseDto getUserContactInfo(Long userContactInfoId) {
        return userContactInfoRepository.findById(userContactInfoId).map(userContactInfoMapper::toUserContactInfoDto).orElseThrow(() ->
                new NotFoundException("UserContactInfo with id: " + userContactInfoId + " could not be found"));
    }

    @Transactional
    @Override
    public void deleteUserContactInfoById(Long userContactInfoId) {
        userContactInfoRepository.deleteById(userContactInfoId);
    }

    @Transactional
    @Override
    public UserContactInfoResponseDto updateUserContactInfo(Long userContactInfoId, UserContactInfoRequestDto userContactInfoRequestDto) {
        return userContactInfoRepository.findById(userContactInfoId)
                .map(userContactInfo -> updateUserContactInfoDto(userContactInfoRequestDto, userContactInfo))
                .map(userContactInfoRepository::save)
                .map(userContactInfoMapper::toUserContactInfoDto)
                .orElse(null);
    }

    private static UserContactInfo updateUserContactInfoDto(UserContactInfoRequestDto userContactInfoRequestDto, UserContactInfo userContactInfo) {
        userContactInfo.setUserCountry(userContactInfoRequestDto.getUserCountry());
        userContactInfo.setUserCity(userContactInfoRequestDto.getUserCity());
        userContactInfo.setUserLocation(userContactInfoRequestDto.getUserLocation());
        userContactInfo.setUserPostCode(userContactInfoRequestDto.getUserPostCode());
        userContactInfo.setUserMobileNumber(userContactInfoRequestDto.getUserMobileNumber());
        return userContactInfo;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserContactInfoResponseDto> getUserContactByUserId(Long userId) {
        return userContactInfoRepository.findUserContactByUserId(userId)
                .stream()
                .map(userContactInfoMapper::toUserContactInfoDto)
                .collect(Collectors.toList());
    }

}