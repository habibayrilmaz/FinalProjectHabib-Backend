package com.example.finalprojecthabibbackend.mapper;


import com.example.finalprojecthabibbackend.dto.request.PermissionRequestDto;
import com.example.finalprojecthabibbackend.dto.response.PermissionResponseDto;
import com.example.finalprojecthabibbackend.model.entity.WorkPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "PermissionMapperImpl", componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "user.id", target = "userId")
    PermissionResponseDto toPermissionDto(WorkPermission permission);

    WorkPermission toPermissionFromCreatePermissionRequest(PermissionRequestDto permissionRequestDto);
}
