package com.example.finalprojecthabibbackend.mapper;


import com.example.finalprojecthabibbackend.dto.request.ExpenseRequestDto;
import com.example.finalprojecthabibbackend.dto.response.ExpenseResponseDto;
import com.example.finalprojecthabibbackend.model.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "ExpenseMapperImpl", componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "user.id", target = "userId")
    ExpenseResponseDto toExpenseDto(Expense expense);

    Expense toExpenseFromCreateExpenseRequest(ExpenseRequestDto expenseRequestDto);

}
