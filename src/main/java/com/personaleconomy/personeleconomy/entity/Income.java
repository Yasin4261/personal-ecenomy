package com.personaleconomy.personeleconomy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "income")
@Getter
@Setter
@ToString
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int amount;
    private LocalDate Date;
    private String title;
    private String Message;
}
