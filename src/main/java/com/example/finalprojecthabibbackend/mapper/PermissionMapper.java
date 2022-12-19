package com.example.finalprojecthabibbackend.mapper;


import com.example.finalprojecthabibbackend.dto.request.PermissionRequestDto;
import com.example.finalprojecthabibbackend.dto.response.PermissionResponseDto;
import com.example.finalprojecthabibbackend.model.entity.WorkPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "PermissionMapperImpl", componentModel = "spring")
public interface PermissionMapper {

    WorkPermission toPermission(PermissionRequestDto permissionRequestDto);

    @Mapping(source = "user.id", target = "userId")
    PermissionResponseDto toPermissionDto(WorkPermission permission);

    WorkPermission toPermissionFromCreatePermissionRequest(PermissionRequestDto permissionRequestDto);

    List<PermissionResponseDto> toPermissionDTOs(List<WorkPermission> workPermissionList);
}
