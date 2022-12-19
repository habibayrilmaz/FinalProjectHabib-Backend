package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.AdvertRequestDto;
import com.example.finalprojecthabibbackend.dto.response.AdvertResponseDto;

import java.util.List;

public interface AdvertService {
    AdvertResponseDto createAdvert(AdvertRequestDto advertRequestDto);
    List<AdvertResponseDto> getAllAdvert();
    AdvertResponseDto getAdvert(Long advertId);
    void deleteAdvertById(Long advertId);
    AdvertResponseDto updateAdvert(Long advertId, AdvertRequestDto advertRequestDto);

}
