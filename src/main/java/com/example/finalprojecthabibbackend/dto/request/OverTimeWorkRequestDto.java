package com.example.finalprojecthabibbackend.dto.request;

import lombok.Data;

@Data
public class OverTimeWorkRequestDto {
    private Long userId;
    private String dateOfOverTimeWork;
    private String timeOfOverTimeWork;
    private String detailOfOverTimeWork;
}
