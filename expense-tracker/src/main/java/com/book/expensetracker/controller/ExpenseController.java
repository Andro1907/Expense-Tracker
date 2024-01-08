package com.book.expensetracker.controller;

import com.book.expensetracker.dto.ExpenseDto;
import com.book.expensetracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@AllArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Void> addExpense(@RequestBody ExpenseDto expenseDto) {
        String expenseId = expenseService.addExpense(expenseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public ExpenseDto getExpense(@PathVariable String id) {
        return expenseService.getExpense(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }

    @PutMapping("/{id}")
    public void updateExpense(@PathVariable String id , @RequestBody ExpenseDto expense) {
        expense.setId(id);
        expenseService.updateExpense(expense);
    }
}
