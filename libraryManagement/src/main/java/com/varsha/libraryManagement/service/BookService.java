package com.varsha.libraryManagement.service;

import com.varsha.libraryManagement.dto.BookDto;
import com.varsha.libraryManagement.entity.Book;
import com.varsha.libraryManagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks()
    {
        List<Book> allBooks = bookRepository.findAll();
        List<BookDto> bookDtoList = allBooks.stream().map(book -> new BookDto(book.getTitle(),book.getAuthor(),book.getISBN(),book.getCategory(),book.getStatus())).toList();
        return bookDtoList;
    }
}
