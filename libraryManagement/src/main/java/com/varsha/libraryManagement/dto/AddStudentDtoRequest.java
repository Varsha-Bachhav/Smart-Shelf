package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddStudentDtoRequest {
    private String name;
    private String email;
    private String phNumber;
    private String department;
    private int year;
    private String address;
}
