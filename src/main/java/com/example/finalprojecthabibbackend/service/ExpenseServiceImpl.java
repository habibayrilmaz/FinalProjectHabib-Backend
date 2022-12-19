package com.example.finalprojecthabibbackend.service;


import com.example.finalprojecthabibbackend.dto.request.ExpenseRequestDto;
import com.example.finalprojecthabibbackend.dto.response.ExpenseResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.ExpenseMapper;
import com.example.finalprojecthabibbackend.model.entity.Expense;
import com.example.finalprojecthabibbackend.model.entity.User;
import com.example.finalprojecthabibbackend.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserService userService;
    private final ExpenseMapper mapperExpense;

    @Transactional
    @Override
    public ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto) {
        User user = userService.getUsers(expenseRequestDto.getUserId());
        if (user.getId() == null) {
            throw new NotFoundException("Expense Not Found!");
        }
        Expense expense = mapperExpense.toExpenseFromCreateExpenseRequest(expenseRequestDto);
        expense.setUser(user);
        return mapperExpense.toExpenseDto(expenseRepository.save(expense));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseResponseDto> getAllExpense() {
        return expenseRepository.findAll().stream().map(mapperExpense::toExpenseDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ExpenseResponseDto getExpense(Long expenseId) {
        return expenseRepository.findById(expenseId).map(mapperExpense::toExpenseDto).orElseThrow(() -> new NotFoundException("Expense with id: " + expenseId + " could not be found"));
    }

    @Transactional
    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Transactional
    @Override
    public ExpenseResponseDto updateExpense(Long expenseId, ExpenseRequestDto expenseRequestDto) {
        return expenseRepository.findById(expenseId).map(expense -> updateExpenseDto(expenseRequestDto, expense)).map(expenseRepository::save).map(mapperExpense::toExpenseDto).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseResponseDto> getExpenseByUserId(Long userId) {
        return expenseRepository.findExpenseByUserId(userId).stream().map(mapperExpense::toExpenseDto).collect(Collectors.toList());
    }

    private static Expense updateExpenseDto(ExpenseRequestDto expenseRequestDto, Expense expense) {
        expense.setExpenseDetail(expenseRequestDto.getExpenseDetail());
        expense.setExpenseAmount(expenseRequestDto.getExpenseAmount());
        expense.setExpenseType(expenseRequestDto.getExpenseType());
        expense.setTaxRate(expenseRequestDto.getTaxRate());
        expense.setVoucherDate(expenseRequestDto.getVoucherDate());
        return expense;
    }

}
