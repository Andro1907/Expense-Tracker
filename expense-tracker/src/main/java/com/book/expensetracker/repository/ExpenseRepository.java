package com.book.expensetracker.repository;

import com.book.expensetracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense,String> {
}
