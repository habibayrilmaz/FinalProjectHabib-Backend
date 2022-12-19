package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;

@Data
public class UserContactInfoResponseDto {
    private long id;
    private Long userId;
    private String userLocation;
    private String userCity;
    private String userMobileNumber;
    private String userCountry;
    private String userPostCode;
}
