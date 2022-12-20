package com.example.finalprojecthabibbackend.controller;


import com.example.finalprojecthabibbackend.dto.request.ExpenseRequestDto;
import com.example.finalprojecthabibbackend.dto.response.ExpenseResponseDto;
import com.example.finalprojecthabibbackend.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expenseService.createExpense(expenseRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpense() {
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> getExpense(@PathVariable Long expenseId) {
        return ResponseEntity.ok(expenseService.getExpense(expenseId));
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{expenseId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<ExpenseResponseDto> updateExpense(@PathVariable Long expenseId, @RequestBody ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expenseService.updateExpense(expenseId, expenseRequestDto));
    }

    @GetMapping("/{userId}/info")
    public ResponseEntity<List<ExpenseResponseDto>> getExpenseForUserId(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok(expenseService.getExpenseByUserId(userId));
    }

}
