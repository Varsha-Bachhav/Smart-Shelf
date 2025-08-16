package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private String member;
    private String memberType;
    private String issuedBook;
    private String issuedDate;
    private String returnDate;
    private String dueDate;
    private String status;
}
