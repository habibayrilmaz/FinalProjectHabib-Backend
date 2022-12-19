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
@SuperBuilder
@Table(name = "expenses_db")
public class Expense extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "type")
    private String expenseType;

    @Column(name = "detail")
    private String expenseDetail;

    @Column(name = "amount")
    private Long expenseAmount;

    @Column(name = "rate")
    private Long taxRate;

    @Column(name = "date")
    private String voucherDate;

}
