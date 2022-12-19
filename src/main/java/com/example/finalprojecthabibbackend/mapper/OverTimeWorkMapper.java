package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.OverTimeWorkRequestDto;
import com.example.finalprojecthabibbackend.dto.response.OverTimeWorkResponseDto;
import com.example.finalprojecthabibbackend.model.entity.OverTimeWork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "OverTimeWorkMapperImpl", componentModel = "spring")
public interface OverTimeWorkMapper {

    OverTimeWork toOverTimeWork(OverTimeWorkRequestDto overTimeWorkRequestDto);

    @Mapping(source = "user.id", target = "userId")
    OverTimeWorkResponseDto toOverTimeWorkDto(OverTimeWork overTimeWork);

    OverTimeWork toOverTimeWorkFromCreateOverTimeWorkRequest(OverTimeWorkRequestDto overTimeWorkRequestDto);

    List<OverTimeWorkResponseDto> toOverTimeWorkDTOs(List<OverTimeWork> overTimeWorkList);
}
