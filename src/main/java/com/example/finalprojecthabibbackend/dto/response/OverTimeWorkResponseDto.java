package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;

@Data
public class OverTimeWorkResponseDto {
    private long id;
    private Long userId;
    private String dateOfOverTimeWork;
    private String timeOfOverTimeWork;
    private String detailOfOverTimeWork;
}
