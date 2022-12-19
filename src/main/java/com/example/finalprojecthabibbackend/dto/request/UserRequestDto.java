package com.example.finalprojecthabibbackend.dto.request;


import lombok.Data;

@Data
public class UserRequestDto {
    private Long userContactInfoId;
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
