package com.example.finalprojecthabibbackend.controller;


import com.example.finalprojecthabibbackend.dto.request.PermissionRequestDto;
import com.example.finalprojecthabibbackend.dto.response.PermissionResponseDto;
import com.example.finalprojecthabibbackend.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/add")
    public ResponseEntity<PermissionResponseDto> createPermission(@RequestBody PermissionRequestDto permissionRequestDto) {
        return ResponseEntity.ok(permissionService.createPermission(permissionRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PermissionResponseDto>> getAllPermission() {
        return ResponseEntity.ok(permissionService.getAllPermission());
    }

    @GetMapping("/{permissionId}")
    public ResponseEntity<PermissionResponseDto> getPermission(@PathVariable Long permissionId) {
        return ResponseEntity.ok(permissionService.getPermission(permissionId));
    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<?> deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermissionById(permissionId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{permissionId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<PermissionResponseDto> updatePermission(@PathVariable Long permissionId, @RequestBody PermissionRequestDto permissionRequestDto) {
        return ResponseEntity.ok(permissionService.updatePermission(permissionId, permissionRequestDto));
    }

}