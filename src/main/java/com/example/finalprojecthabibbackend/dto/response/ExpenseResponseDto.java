package com.example.finalprojecthabibbackend.dto.response;

import lombok.Data;

@Data
public class ExpenseResponseDto {
    private long id;
    private Long userId;
    private String expenseType;
    private String expenseDetail;
    private Long expenseAmount;
    private Long taxRate;
    private String voucherDate;
}

