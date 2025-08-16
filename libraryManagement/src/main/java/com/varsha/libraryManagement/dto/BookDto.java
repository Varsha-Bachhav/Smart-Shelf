package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String title;
    private String author;
    private String ISBN;
    private String category;
    private String status;
}