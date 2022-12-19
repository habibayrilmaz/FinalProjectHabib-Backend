package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.PermissionRequestDto;
import com.example.finalprojecthabibbackend.dto.response.PermissionResponseDto;

import java.util.List;

public interface PermissionService {
    PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto);
    List<PermissionResponseDto> getAllPermission();
    PermissionResponseDto getPermission(Long permissionId);
    void deletePermissionById(Long permissionId);
    PermissionResponseDto updatePermission(Long permissionId, PermissionRequestDto permissionRequestDto);

}
