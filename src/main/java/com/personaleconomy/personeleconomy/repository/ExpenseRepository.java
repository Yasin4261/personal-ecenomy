package com.personaleconomy.personeleconomy.repository;

import com.personaleconomy.personeleconomy.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
