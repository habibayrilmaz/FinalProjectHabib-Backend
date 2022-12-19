package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;

@Data
public class PermissionResponseDto {
    private long id;
    private Long userId;
    private String permissionType;
    private Long totalPermissionDay;
    private String startDatePermission;
    private String endDatePermission;
    private String permissionDetail;
    private String dateOfReturn;
}
