package com.varsha.libraryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String member;
    private String memberType;
    private String issuedBook;
    private String issuedDate;
    private String returnDate;
    private String dueDate;
    private String status;
}
