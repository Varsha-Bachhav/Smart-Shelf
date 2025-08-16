package com.varsha.libraryManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnBookDtoRequest {
    private String member;
    private String issuedBook;
    private String returnDate;
    private String status;
}
