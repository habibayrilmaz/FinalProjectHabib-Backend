package com.example.finalprojecthabibbackend.model.entity;

import com.example.finalprojecthabibbackend.model.entity.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_contact_db")
@Entity
@SuperBuilder
public class UserContactInfo extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "address")
    private String userLocation;

    @Column(name = "city")
    private String userCity;

    @Column(name = "mobile_no")
    private String userMobileNumber;

    @Column(name = "country")
    private String userCountry;

    @Column(name = "post_code")
    private String userPostCode;
}
