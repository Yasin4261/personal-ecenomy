package com.personaleconomy.personeleconomy.service;

import com.personaleconomy.personeleconomy.entity.Expense;
import com.personaleconomy.personeleconomy.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense) { return expenseRepository.save(expense);}

    public List<Expense> findAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long expenseId) {
        return expenseRepository.findById(expenseId).get();
    }

    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }
}
