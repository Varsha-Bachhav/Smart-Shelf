package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookDtoRequest {
    private String member;
    private String memberType;
    private String issuedBook;
    private String issuedDate;
    private String dueDate;
    private String status;
}
