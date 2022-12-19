package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;

@Data
public class AdvertResponseDto {
    private long id;
    private String advertHeader;
    private String advertPosition;
    private String advertDepartment;
    private String advertType;
    private String advertDetail;
}
