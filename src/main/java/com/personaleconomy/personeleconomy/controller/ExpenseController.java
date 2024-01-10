package com.personaleconomy.personeleconomy.controller;

import com.personaleconomy.personeleconomy.entity.Expense;
import com.personaleconomy.personeleconomy.service.ExpenseService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpense(){
        List<Expense> allExpense = expenseService.findAllExpense();
        ResponseEntity<List<Expense>> listResponseEntity = new ResponseEntity<>(allExpense, HttpStatus.OK);

        return listResponseEntity;
    }

    @PostMapping("/save")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        Expense addExpense = expenseService.addExpense(expense);
        ResponseEntity<Expense> expenseResponseEntity = new ResponseEntity<>(addExpense, HttpStatus.CREATED);
        return expenseResponseEntity;
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getExpenseId(@PathVariable("id") Long id){
        Expense expenseById = expenseService.getExpenseById(id);
        ResponseEntity<Expense> expenseResponseEntity = new ResponseEntity<>(expenseById, HttpStatus.OK);
        return expenseResponseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") Long id){
        expenseService.deleteExpenseById(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
