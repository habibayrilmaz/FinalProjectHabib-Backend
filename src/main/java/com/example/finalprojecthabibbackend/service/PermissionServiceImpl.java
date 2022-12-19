package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.PermissionRequestDto;
import com.example.finalprojecthabibbackend.dto.response.PermissionResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.PermissionMapper;
import com.example.finalprojecthabibbackend.model.entity.User;
import com.example.finalprojecthabibbackend.model.entity.WorkPermission;
import com.example.finalprojecthabibbackend.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final UserService userService;
    private final PermissionMapper permissionMapper;
    private final PermissionRepository permissionRepository;

    @Transactional
    @Override
    public PermissionResponseDto createPermission(PermissionRequestDto permissionRequestDto) {
        User user = userService.getUsers(permissionRequestDto.getUserId());
        if (user.getId() == null) {
            throw new NotFoundException("Permission Not Found!");
        }
        WorkPermission workPermission = permissionMapper.toPermissionFromCreatePermissionRequest(permissionRequestDto);
        workPermission.setUser(user);
        return permissionMapper.toPermissionDto(permissionRepository.save(workPermission));
    }

    @Transactional(readOnly = true)
    @Override
    public List<PermissionResponseDto> getAllPermission() {
        return permissionRepository.findAll().stream().map(permissionMapper::toPermissionDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public PermissionResponseDto getPermission(Long permissionId) {
        return permissionRepository.findById(permissionId).map(permissionMapper::toPermissionDto).orElseThrow(() -> new NotFoundException("Work Permission with id: " + permissionId + " could not be found"));
    }

    @Transactional
    @Override
    public void deletePermissionById(Long permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    @Transactional
    @Override
    public PermissionResponseDto updatePermission(Long permissionId, PermissionRequestDto permissionRequestDto) {
        return permissionRepository.findById(permissionId)
                .map(workPermission -> updatePermissionDto(permissionRequestDto, workPermission))
                .map(permissionRepository::save)
                .map(permissionMapper::toPermissionDto)
                .orElse(null);
    }

    private static WorkPermission updatePermissionDto(PermissionRequestDto permissionRequestDto, WorkPermission workPermission) {
        workPermission.setPermissionDetail(permissionRequestDto.getPermissionDetail());
        workPermission.setPermissionType(permissionRequestDto.getPermissionType());
        workPermission.setEndDatePermission(permissionRequestDto.getEndDatePermission());
        workPermission.setStartDatePermission(permissionRequestDto.getStartDatePermission());
        workPermission.setTotalPermissionDay(permissionRequestDto.getTotalPermissionDay());
        workPermission.setDateOfReturn(permissionRequestDto.getDateOfReturn());
        return workPermission;
    }


}
