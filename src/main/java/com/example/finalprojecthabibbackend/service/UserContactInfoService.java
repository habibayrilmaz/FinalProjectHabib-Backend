package com.example.finalprojecthabibbackend.service;


import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserContactInfoResponseDto;

import java.util.List;

public interface UserContactInfoService {
    UserContactInfoResponseDto createUserContactInfo(UserContactInfoRequestDto userContactInfoRequestDto);
    List<UserContactInfoResponseDto> getAllUserContactInfo();
    UserContactInfoResponseDto getUserContactInfo(Long userContactInfoId);
    void deleteUserContactInfoById(Long userContactInfoId);
    UserContactInfoResponseDto updateUserContactInfo(Long userContactInfoId, UserContactInfoRequestDto userContactInfoRequestDto);
    List<UserContactInfoResponseDto> getUserContactByUserId(Long userId);

}
