package com.example.finalprojecthabibbackend.model.entity;


import com.example.finalprojecthabibbackend.model.entity.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_db")
@Entity
@SuperBuilder
public class User extends AbstractEntity {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Expense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkPermission> workPermissions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OverTimeWork> overTimeWorkList = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserContactInfo userContactInfo;

    @Column(name = "name")
    private String userName;

    @Column(name = "surname")
    private String userSurname;

    @Column(name = "mail")
    private String userMailAddress;

    @Column(name = "identification")
    private String userIdentificationNumber;

    @Column(name = "salary")
    private String userSalary;

    @Column(name = "start_date")
    private String userStartDate;

    @Column(name = "seniority")
    private String userSeniority;

    @Column(name = "seniority_level")
    private String userSeniorityLevel;

    @Column(name = "role")
    private String userRole;

    @Column(name = "department")
    private String userDepartment;

    @Column(name = "birth_date")
    private String userBirthDate;

}
