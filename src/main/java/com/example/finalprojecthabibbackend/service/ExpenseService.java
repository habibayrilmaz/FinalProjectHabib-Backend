package com.example.finalprojecthabibbackend.service;


import com.example.finalprojecthabibbackend.dto.request.ExpenseRequestDto;
import com.example.finalprojecthabibbackend.dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto);
    List<ExpenseResponseDto> getAllExpense();
    ExpenseResponseDto getExpense(Long expenseId);
    void deleteExpenseById(Long expenseId);
    ExpenseResponseDto updateExpense(Long expenseId, ExpenseRequestDto expenseRequestDto);
    List<ExpenseResponseDto> getExpenseByUserId(Long userId);
}
