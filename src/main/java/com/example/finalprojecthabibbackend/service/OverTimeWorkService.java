package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.OverTimeWorkRequestDto;
import com.example.finalprojecthabibbackend.dto.response.OverTimeWorkResponseDto;

import java.util.List;

public interface OverTimeWorkService {
    OverTimeWorkResponseDto createOverTimeWork(OverTimeWorkRequestDto overTimeWorkRequestDto);
    List<OverTimeWorkResponseDto> getAllOverTimeWork();
    OverTimeWorkResponseDto getOverTimeWork(Long overTimeWorkId);
    void deleteOverTimeWorkById(Long overTimeWorkId);
    OverTimeWorkResponseDto updateOverTimeWork(Long overTimeWorkId, OverTimeWorkRequestDto overTimeWorkRequestDto);

}
