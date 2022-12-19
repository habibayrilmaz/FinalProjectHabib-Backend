package com.example.finalprojecthabibbackend.dto.request;

import lombok.Data;

@Data
public class UserContactInfoRequestDto {
    private Long userId;
    private String userLocation;
    private String userCity;
    private String userMobileNumber;
    private String userCountry;
    private String userPostCode;
}
