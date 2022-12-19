package com.example.finalprojecthabibbackend.model.entity;

import com.example.finalprojecthabibbackend.model.entity.base.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adverts_db")
@SuperBuilder
public class Advert extends AbstractEntity {

    @Column(name = "header")
    private String advertHeader;

    @Column(name = "position")
    private String advertPosition;

    @Column(name = "department")
    private String advertDepartment;

    @Column(name = "type")
    private String advertType;

    @Column(name = "detail")
    private String advertDetail;

}