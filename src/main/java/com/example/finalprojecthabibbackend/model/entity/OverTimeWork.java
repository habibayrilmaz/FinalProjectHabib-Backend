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
@Table(name = "overtime_work_db")
@SuperBuilder
public class OverTimeWork extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    private String dateOfOverTimeWork;

    @Column(name = "time")
    private String timeOfOverTimeWork;

    @Column(name = "detail")
    private String detailOfOverTimeWork;

}
