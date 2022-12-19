package com.example.finalprojecthabibbackend.repository;

import com.example.finalprojecthabibbackend.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query(value = """
            SELECT e
            FROM  Expense e
            WHERE e.user.id=:userId
            """)
    List<Expense> findExpenseByUserId(@Param("userId") Long userId);

}
