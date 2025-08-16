package com.varsha.libraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDetailsDto {
    private long totalBooks;
    private long activeMembers;
    private long booksCheckedOut;
    private long overdueBooks;
}
