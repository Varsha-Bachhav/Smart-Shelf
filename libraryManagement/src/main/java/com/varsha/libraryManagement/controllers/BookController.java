package com.varsha.libraryManagement.controllers;

import com.varsha.libraryManagement.dto.BookDto;
import com.varsha.libraryManagement.entity.Book;
import com.varsha.libraryManagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    private final BookService bookService;

    @GetMapping("/getAllBooks")
    public List<BookDto> getAllBooks()
    {
        List<BookDto> allBooks = bookService.getAllBooks();
        return allBooks;
    }
}