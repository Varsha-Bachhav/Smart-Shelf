package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private String phNumber;
    private String department;
    private int year;
    private String address;

    public StudentDto(long id, String name, String email, String phNumber, String department, int year, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phNumber = phNumber;
        this.department = department;
        this.year = year;
        this.address = address;
    }
}