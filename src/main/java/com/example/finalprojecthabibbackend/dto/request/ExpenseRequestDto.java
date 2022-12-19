package com.example.finalprojecthabibbackend.dto.request;

import lombok.Data;

@Data
public class ExpenseRequestDto {
    private Long userId;
    private String expenseType;
    private String expenseDetail;
    private Long expenseAmount;
    private Long taxRate;
    private String voucherDate;
}

