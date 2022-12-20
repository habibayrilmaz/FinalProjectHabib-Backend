package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.OverTimeWorkRequestDto;
import com.example.finalprojecthabibbackend.dto.response.OverTimeWorkResponseDto;
import com.example.finalprojecthabibbackend.model.entity.OverTimeWork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "OverTimeWorkMapperImpl", componentModel = "spring")
public interface OverTimeWorkMapper {

    @Mapping(source = "user.id", target = "userId")
    OverTimeWorkResponseDto toOverTimeWorkDto(OverTimeWork overTimeWork);

    OverTimeWork toOverTimeWorkFromCreateOverTimeWorkRequest(OverTimeWorkRequestDto overTimeWorkRequestDto);
}
