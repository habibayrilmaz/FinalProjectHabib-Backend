package com.example.finalprojecthabibbackend.dto.request;

import lombok.Data;

@Data
public class PermissionRequestDto {
    private Long userId;
    private String permissionType;
    private Long totalPermissionDay;
    private String startDatePermission;
    private String endDatePermission;
    private String permissionDetail;
    private String dateOfReturn;
}
