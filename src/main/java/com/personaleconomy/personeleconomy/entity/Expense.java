package com.personaleconomy.personeleconomy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Getter
@Setter
@ToString
public class Expense {

    private int amount;
    private LocalDate Date;
    private String title;
    private String Message;
}
