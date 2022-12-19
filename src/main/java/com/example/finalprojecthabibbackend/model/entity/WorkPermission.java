package com.example.finalprojecthabibbackend.model.entity;

import com.example.finalprojecthabibbackend.model.entity.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission_db")
@SuperBuilder
public class WorkPermission extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "type")
    private String permissionType;

    @Column(name = "total_day")
    private Long totalPermissionDay;

    @Column(name = "start_date")
    private String startDatePermission;

    @Column(name = "end_date")
    private String endDatePermission;

    @Column(name = "detail")
    private String permissionDetail;

    @Column(name = "return_date")
    private String dateOfReturn;
}