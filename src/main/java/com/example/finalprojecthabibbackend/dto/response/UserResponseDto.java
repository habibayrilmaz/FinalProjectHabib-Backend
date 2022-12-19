package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;


@Data
public class UserResponseDto {
    private Long userContactInfoId;
    private long id;
    private String userName;
    private String userSurname;
    private String userMailAddress;
    private String userIdentificationNumber;
    private String userSalary;
    private String userStartDate;
    private String userSeniority;
    private String userSeniorityLevel;
    private String userRole;
    private String userDepartment;
    private String userBirthDate;
}
